package com.asiainfo.abdinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.NewLoginBean.ListAllFeeling;
import com.asiainfo.abdinfo.po.NewLoginBean.NewLogin;

public interface NewLoginPage {
	
	/*插入用户信息*/
	void insertUser(Map map);
	
	
	void deleteUser(Map map);
	
	/**
	 * 查询用户
	 * @param map
	 * @return
	 */
	public List<NewLogin> findUser(Map map);
	
	/**
	 * 注册 即更新
	 * @param map
	 */
	void updateUser(Map map);
	
	void updateUserNewe(Map map);
	
	/*
	 * 查询用户新
	 */
	List<NewLogin> findNewUser(@Param(value="openId") String openId);
	
	/**
	 * 用于展示用户的感想
	 */
	List<ListAllFeeling> findAllFeeling(Map map);
	
	/**
	 * 查询员工编码
	 * @param map
	 * @return
	 */
	List<NewLogin> selectUser(Map map);
	
	/**
	 * 根据openId删除不同于现在openId的用户，主要用于openId变化时
	 * */
	void deleteUserByOpenId(Map map);
	/**
	 * 用于头像的显示
	 * */
	ListAllFeeling findbaseByCode(Map map);
}





