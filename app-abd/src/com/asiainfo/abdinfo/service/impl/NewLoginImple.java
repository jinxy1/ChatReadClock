package com.asiainfo.abdinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.abdinfo.dao.NewLoginPage;
import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.po.NewLoginBean.ListAllFeeling;
import com.asiainfo.abdinfo.po.NewLoginBean.NewLogin;
import com.asiainfo.abdinfo.service.NewLoginService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;
import com.github.pagehelper.PageHelper;



@Service(value="NewLoginService")
public class NewLoginImple implements NewLoginService{
	
	@Autowired
	private NewLoginPage newLoginPage;

	@Override
	public void insertUser(Map map) {
		newLoginPage.insertUser(map);
		
	}

	@Override
	public List<NewLogin> getUser(Map map) {
		return newLoginPage.findUser(map);
	}

	@Override
	public void regUser(String userId, String password, String openId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("openId", openId);
		map.put("userId", userId);
		map.put("password", password);
		newLoginPage.updateUserNewe(map);
		newLoginPage.deleteUserByOpenId(map);
	}

	@Override
	public List<NewLogin> getNewUser(String openId) {		
		return newLoginPage.findNewUser(openId);
	}
   
	
	/**
	 * 显示用户的所有感想
	 */
	@Override
	public PageBean getAllFeeling(Map map,PageBounds pb) {		
	    PageHelper.startPage(pb.getPage(), pb.getLimit());
		List<ListAllFeeling> list=newLoginPage.findAllFeeling(map);
		System.out.println(list);
		PageBean  pageBean  = new PageBean(list);
		return pageBean;
		
	}

	@Override
	public void deleteUser(Map map) {
		newLoginPage.deleteUser(map);
		
	}

	@Override
	public List<NewLogin> selectUser(Map map) {	
		return newLoginPage.selectUser(map);
	}
	
	@Override
	public ListAllFeeling findbaseByCode(String staffCode) {	
		Map map=new HashMap();
		map.put("staffCode", staffCode);
		return newLoginPage.findbaseByCode(map);
	}

	@Override
	public void updateUser(Map map) {
		newLoginPage.updateUser(map);
		
	}
}












