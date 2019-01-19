package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.User;

public interface ITipsService {
	
	public Map<String, Integer> addTipsDailyfeeling(Map<String, Object> map);
	public List<User> findTips(Map<String, Object> map);
	public int deleteTipsOwes_content(Map<String, Object> map);
}
