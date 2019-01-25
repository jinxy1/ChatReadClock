package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.ReadClock;

public interface ReadClockService {
	/**
	 * 在readclock页面和"我的"页面查询读书感悟
	 */
	Map getReadIndex(String staffCode,String clockDate);
	
	/**
	 * 数据的插入即更新
	 * 填写读书感悟
	 * @param request
	 * @param response
	 */
	void updateBook(Map map);
	
	
	/**
	 * 展示读书页面中已读和需读的内容
	 */
	List<ReadClock> getReadIndex1(Map map);
	
	
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
