package com.asiainfo.abdinfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.common.CurrentTime;
import com.asiainfo.abdinfo.dao.ReadClockDao;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.po.ReadCount;
import com.asiainfo.abdinfo.service.ReadClockService;

@Service("ReadClockService")
public class ReadClockImple implements ReadClockService {

	@Resource
	private ReadClockDao readClockDao;
	/**
	 * 在readclock页面和"我的"页面查询读书感悟
	 */
	@Override
	public Map<String,Object> getReadIndex(String staffCode,String clockDate) {
		if(clockDate.equals("undefined")||clockDate==null){
			clockDate=CurrentTime.getCurrentTime();
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		map.put("clockDate", clockDate);
		List<ReadClock> rc = readClockDao.findReadIndex(map);
		ReadCount rr = readClockDao.findCount(map);
		String r = readClockDao.findCountPeople(map);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("rc", rc);
		m.put("rr", rr);
		m.put("r", r);
		return m;
	}
	/**
	 * 数据的插入即更新
	 * 填写读书感悟
	 */
	@Override
	public void updateBook(Map<String,Object> map) {
		readClockDao.updateBook(map);
	}
	/**
	 * 展示读书页面中已读和需读的内容
	 */
	@Override
	public List<ReadClock> getReadIndex1(Map<String,Object> map) {
		map.put("beginClockDate", CurrentTime.getBeforeTime());
		map.put("endClockDate", CurrentTime.getAfterTime());	
		return readClockDao.findReadIndex(map);
	}
	
	/**
	 * 该功能用来根据日历查询数据
	 */
	@Override
	public List<Map<String,Object>> getCalendar(Map<String,Object> map) {
	
		return 	readClockDao.selectCalendar(map);
	}

	/**
	 * 查询读书心得的积分
	 */
	@Override
	public String getIntegralRead(String staffCode, String clockDate) {
		return readClockDao.selectIntegralRead(staffCode, clockDate);
	}
    
	/**
	 * 绘制积分图案
	 */
	@Override
	public List<String> getIconLevel(String staffCode) {
		String tconLevel=readClockDao.selectIconLevel(staffCode);
		List<String> list=new ArrayList<String>();
		
		 String[] icon=tconLevel.split(",");
		 for(String a:icon){
			 list.add(a.trim());
		 }
		
		return list;
	}

}







