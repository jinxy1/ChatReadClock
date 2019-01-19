package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.User;

public interface ITipsDao {
	
	public int addTipsDailyfeeling(Map<String, Object> map);
	/**
	 * 韩启龙到此一游
	 * @param map
	 * @return
	 */
	public int addTipsOwes_content(Map<String, Object> map);
	public List<User> findTips(Map<String, Object> map);
	public int updateTipsDailyfeeling(Map<String, Object> map);
	public int updateTipsOwes_content(Map<String, Object> map);
	public int deleteTipsOwes_content(Map<String, Object> map);
	public int updateCustomContent(Map<String, Object> map);//更新自主内容
	public int deleteOwes_content(Map<String, Object> map);//删除当前感恩信息添加新的感恩信息

}
