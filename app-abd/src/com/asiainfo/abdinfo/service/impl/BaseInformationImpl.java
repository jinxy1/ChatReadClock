/**
 * @date 2018年5月29日
 */
package com.asiainfo.abdinfo.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.BaseInformationPage;
import com.asiainfo.abdinfo.po.BaseInformation;
import com.asiainfo.abdinfo.service.BaseInformationService;

@Service("BaseInformationService")
public class BaseInformationImpl implements BaseInformationService{

	
	@Autowired
	private BaseInformationPage baseInformationPage;
	@Override
	public List<BaseInformation>  getBaseInformation(Map id) {
		List<BaseInformation>  ba=baseInformationPage.findBaseInformation(id);
		return ba;
	}
	
	
	@Override
	public List<BaseInformation>  getBaseInformation() {
		List<BaseInformation>  ba=baseInformationPage.findBaseInformation();
		return ba;
	}


	@Override
	public void getDeleteBaseInformation(Integer id) {
		baseInformationPage.DeleteBaseInformation(id);
		System.out.println("删除成功");
	}


	@Override
	public void addBaseInformation(String areaName, String priority) {
		baseInformationPage.addBaseInformation(areaName, priority);
		System.out.println("添加成功");
	}


	


	
}











