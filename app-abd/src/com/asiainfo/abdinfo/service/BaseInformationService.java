package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.BaseInformation;

public interface BaseInformationService {
	
	public List<BaseInformation>  getBaseInformation(Map id);
	
	public List<BaseInformation>  getBaseInformation();
	
	public void getDeleteBaseInformation(Integer id);
	
	void addBaseInformation(String areaName , String priority);

}
