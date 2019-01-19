package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.po.NewLoginBean.ListAllFeeling;
import com.asiainfo.abdinfo.po.NewLoginBean.NewLogin;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

public interface NewLoginService {
	
	/*插入用户信息*/
	void insertUser(Map map);
	void deleteUser(Map map);
	
	public List<NewLogin> getUser(Map map);
	
	void regUser(String userId,String password,String openId);
	
	public List<NewLogin> getNewUser(String openId);
	
	/**
	 * 用于展示用户的感想
	 */
	PageBean  getAllFeeling(Map map,PageBounds pb);
	
	List<NewLogin> selectUser(Map map);
	/**
	 * 用于头像的显示
	 * */
	ListAllFeeling findbaseByCode(String staffCode);
	
	/**
	 * 若用户信息已存在更新
	 * @param map
	 */
	void updateUser(Map map);
	
	

}
