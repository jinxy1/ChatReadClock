package com.asiainfo.abdinfo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.common.CurrentTime;
import com.asiainfo.abdinfo.dao.ReadClockDao;
import com.asiainfo.abdinfo.po.Announcement;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.po.ReadCount;
import com.asiainfo.abdinfo.service.ReadClockService;

@Service("ReadClockService")
public class ReadClockImple implements ReadClockService {

	@Resource
	private ReadClockDao readClockDao;

	@Override
	public Map getReadIndex(String staffCode,String clockDate) {
		if(clockDate.equals("undefined")||clockDate==null){
			clockDate=CurrentTime.getCurrentTime();
		}
		Map<String,String> map=new HashMap<String,String>();
		map.put("staffCode", staffCode);
		map.put("clockDate", clockDate);
		List<ReadClock> rc = readClockDao.findReadIndex(map);
		ReadCount rr = readClockDao.findCount(map);
		String r = readClockDao.findCountPeople(map);
		Map m=new HashMap();
		m.put("rc", rc);
		m.put("rr", rr);
		m.put("r", r);
		return m;
	}

	@Override
	public void updateBook(Map map) {
		readClockDao.updateBook(map);
	}

	@Override
	public List<ReadClock> getReadIndex1(Map map) {
		map.put("beginClockDate", CurrentTime.getBeforeTime());
		map.put("endClockDate", CurrentTime.getAfterTime());	
		return readClockDao.findReadIndex(map);
	}

	@Override
	public List<Announcement> getAnnount() {
		return readClockDao.findAnnount();
	}

	
	/**
	 * 该功能用来查询数据
	 */
	@Override
	public List<Map> getCalendar(Map map) {
	
		return 	readClockDao.selectCalendar(map);
	}

	/**
	 * 查询读书心得的数据
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






