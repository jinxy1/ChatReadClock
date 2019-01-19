package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.User;



public interface IUserUserDao {
	
	/**
	 * 登陆
	 * @param map
	 * @return
	 */
	public User findUserByIdAndName(Map<String, Object> map);
	
	public List<String>findDepartment(Map<String, Object> map);
	
	public List<User> findDepartmentPeople(Map<String, Object> map);

}
