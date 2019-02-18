package com.asiainfo.abdinfo.service.impl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.CalendarDao;
import com.asiainfo.abdinfo.dao.LinkageHomeDao;
import com.asiainfo.abdinfo.po.Calendar;
import com.asiainfo.abdinfo.po.DayRest;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.service.ReadClockService;
import com.asiainfo.abdinfo.service.linkageHomeService;

@Service("linkageHomeService")
public class LinkageHomeImple implements linkageHomeService{
	
	/** 首页点击封面获取书单 */
	@Autowired
	private LinkageHomeDao linkageHomeDao;
	
	@Autowired
	private CalendarDao calendarDao;
	
	@Autowired
	private ReadClockService readClockService;

	@Override
	public List<ReadClock> getLinkage(Map<String,Object> map) {
		return linkageHomeDao.findLinkage(map);	
	}
   
	/**
	 * 节约空间弄日历
	 */
	@Override
	public List<Calendar> selectCalendarContent(String staffCode, String date) {
//		List<Calendar> cal=calendarDao.selectCalendarContent( staffCode,  date);
//		System.out.println(cal);
		List<Calendar> attend=getAttendance( staffCode,  date);
//		for(Calendar c:cal){
//			attend.add(c);
//		}
//		System.out.println(attend);
		return attend;
		
	}
  
	/**
	 * 考勤表
	 */
	@Override
	public List<Calendar> getAttendance(String staffCode, String date) {
		long startTime=System.currentTimeMillis();
		//List<DayRest>  holiday=readClockService.selectDayRest(staffCode, date, date, "dateEqul");   //假期      若空不放假     若不为空放假
		List<String>  calendarTime=calendarDao.selectAttendance(staffCode, date);                        //打卡(按指纹)记录        若空未打卡    若不为空打卡
		System.out.println(calendarTime.size());
		List<Calendar>  calendar=new ArrayList<Calendar>();    //存放上下班的集合
		Calendar goWork=new Calendar();          //存放上班的对象
		Calendar downWork=new Calendar();          //存放下班的对象
		
		goWork.setProject("上班时间");
		downWork.setProject("下班时间");
		goWork.setIcon("sumRound");
		downWork.setIcon("moonRound");
		List<String> goWorkList=new ArrayList<String>();
		List<String> downWorkList=new ArrayList<String>();
		
		if(calendarTime.size()!=0){  //打卡
			//当多条记录时
			int maxDate=dateConversion(calendarTime.get(0));      //最大值 
			int minDate=dateConversion(calendarTime.get(0));      //最小值
			for(int i=0;i<calendarTime.size();i++){
				//如果只有一条打卡记录
				if(calendarTime.size()==1){  
					int calendarInt=Integer.parseInt(calendarTime.get(i).substring(0, 2));		//从数据库中查出的小时						
					if(calendarInt<12){
						//上班

						minDate=dateConversion(calendarTime.get(i));
						maxDate=0;
					
					}else{
					   //下班	
						minDate=0;
						maxDate=dateConversion(calendarTime.get(i));
					}
				}else{
					//若有多条打卡记录
					if(dateConversion(calendarTime.get(i))<minDate){
						minDate=dateConversion(calendarTime.get(i));
					}
					
					if(dateConversion(calendarTime.get(i))>maxDate){
						maxDate=dateConversion(calendarTime.get(i));
					}
				}
			}
			goWorkList.add(intConversion(minDate));
			downWorkList.add(intConversion(maxDate));
		}else{           //未打卡
//			if(holiday.size()!=0){  //放假
//				
//			}else{       //不放假
//			}
			int minDate=0;
			int maxDate=0;
			goWorkList.add(intConversion(minDate));
			downWorkList.add(intConversion(maxDate));
		}
		
		goWork.setContents(goWorkList);
		downWork.setContents(downWorkList);
		System.out.println(calendar);
		List<Calendar> cal=calendarDao.selectCalendarContent( staffCode,  date);
		cal.add(0,goWork);
		cal.add(downWork);
//		calendar.add(goWork);
//		calendar.add(downWork);

	  
	    long begtinTime=System.currentTimeMillis();
	    System.out.println("--------------考勤所用时间-------------------"+(begtinTime-startTime));
	    return cal;
	}

	
    //将String型 转化为int 型
	private int dateConversion(String str){
		int a=Integer.parseInt(str.substring(0,2))*60*60;
		int b =Integer.parseInt(str.substring(3,5))*60;
		int c=Integer.parseInt(str.substring(6,8));
		int tatal=a+b+c;
		return tatal;
	}

	
	//将int类型转化为String型
	private String intConversion(int str){
		if(str==0){
			return "";
		}
		int a=str/60/60;    //时
		int b=str/60%60;    //分
		int c=str%60;       //秒
		String total=a+":"+b+":"+c;
		return total;
	}

	
	/**
	 * 判断是否有读书内容
	 */
	@Override
	public String judgeRead(String staffCode, String date) {
		
		return calendarDao.judgeRead(staffCode, date);
	}

	



}
