package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.Announcement;
import com.asiainfo.abdinfo.po.ReadClock;

public interface ReadClockService {
	
	Map getReadIndex(String staffCode,String clockDate);
	
	void updateBook(Map map);
	
	List<ReadClock> getReadIndex1(Map map);
	
	List<Announcement> getAnnount();
	
	
	/**
	 * 查数据 该功能用来做日历模块
	 * @param map
	 * @return
	 */
	List<Map> getCalendar(Map map);
	
	
	
	/**
	 * 查询读书心得的数据
	 * @param staffCode
	 * @param clockDate
	 * @return
	 */
	String getIntegralRead(String staffCode, String clockDate);
	
	/**
	 * 绘制积分图案
	 * @return
	 */
	List<String> getIconLevel(String staffCode);
	


}
