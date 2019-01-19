package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.BaseInformation;

public interface BaseInformationPage {
	
	
	List<BaseInformation>  findBaseInformation (Map id);
	
	List<BaseInformation>   findBaseInformation ();
	
	void DeleteBaseInformation(@Param(value="id") Integer id);
	
	
	/**
	 * 最终会变成什么样呢？
	 * @param areaName
	 * @param priority
	 */
	void addBaseInformation(@Param(value="areaName") String areaName ,@Param(value="priority") String priority);
	
	
	
	
	
}




