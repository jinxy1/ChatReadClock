package com.asiainfo.abdinfo.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.abdinfo.dao.LinkageHomeDao;
import com.asiainfo.abdinfo.po.Book;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.service.linkageHomeService;

@Service("linkageHomeService")
public class LinkageHomeImple implements linkageHomeService{
	
	@Autowired
	private LinkageHomeDao linkageHomeDao;

	@Override
	public List<ReadClock> getLinkage(Map map) {
		return linkageHomeDao.findLinkage(map);	
	}

	

	




}