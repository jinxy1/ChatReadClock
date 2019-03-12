package com.asiainfo.abdinfo.controller.community;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.service.ICommunityService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

@Controller
@RequestMapping(value="community")
public class CommunityController {
	
	@Autowired
	private ICommunityService iCommunityService;
	
	@RequestMapping(value="getCommunityInfoType.do")
	@ResponseBody
	public Map<String, Object> getCommunityInfoType(String user,String typeName){
		User users=JSON.parseObject(user,User.class);
		int page=Integer.parseInt("0");
		int limit=Integer.valueOf("10");
		JSON.parse(user);
		System.out.println(typeName.length());
		System.out.println(user);
		PageBounds pb = new PageBounds(page,limit);
		return iCommunityService.getCommunityMsType(users,typeName,pb);
	}
}
