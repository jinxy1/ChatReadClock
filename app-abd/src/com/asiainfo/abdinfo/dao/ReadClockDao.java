package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.Announcement;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.po.ReadCount;

public interface ReadClockDao {
	
	/**
	 * 查询信息
	 * @param map
	 * @return
	 */
	List<ReadClock> findReadIndex(Map map);
	
	/**
	 * 各种统计
	 * @return
	 */
	ReadCount findCount(Map map);
	
	/*
	 * 判断有多少人上线 
	 */
	String findCountPeople(Map map);
	
	/**
	 * 插入数据即更新
	 * @param map
	 */
	void updateBook(Map map);
	
	
	List<Announcement> findAnnount();
	
	
	/**
	 * 查数据 该功能用来做日历模块
	 * @param map
	 * @return
	 */
	List<Map> selectCalendar(Map map);
	
	
	/**
	 * 查询读书心得的积分
	 * @param staffCode
	 * @param clockDate
	 * @return
	 */
	String selectIntegralRead(@Param(value="staffCode") String staffCode,@Param(value="clockDate") String clockDate);
	
	/**
	 * 绘制积分图案
	 * @return
	 */
	String selectIconLevel(@Param(value="staffCode") String staffCode);
	

	
	
}








