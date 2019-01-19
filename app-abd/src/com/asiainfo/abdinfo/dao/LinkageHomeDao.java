package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.Book;
import com.asiainfo.abdinfo.po.ReadClock;

public interface LinkageHomeDao {
	
	public List<ReadClock>  findLinkage(Map map);
	
	
	
	
}
