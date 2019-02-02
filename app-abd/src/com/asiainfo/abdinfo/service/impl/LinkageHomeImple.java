package com.asiainfo.abdinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.LinkageHomeDao;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.service.linkageHomeService;
/** 首页点击封面获取书单 */
@Service("linkageHomeService")
public class LinkageHomeImple implements linkageHomeService{
	
	@Autowired
	private LinkageHomeDao linkageHomeDao;

	@Override
	public List<ReadClock> getLinkage(Map<String,Object> map) {
		return linkageHomeDao.findLinkage(map);	
	}

	

	




}
