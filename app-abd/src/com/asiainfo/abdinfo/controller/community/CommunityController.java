package com.asiainfo.abdinfo.controller.community;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.po.community.CommunityInfoRead;
import com.asiainfo.abdinfo.service.ICommunityService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

@Controller
@RequestMapping(value="community")
public class CommunityController {
	
	@Autowired
	private ICommunityService iCommunityService;
	
	@RequestMapping(value="getCommunityInfoType.do")
	@ResponseBody
	public Map<String, Object> getCommunityInfoType(String user,String typeName,HttpServletRequest request) throws InterruptedException{
		//Thread.sleep(2000);
		String pagestr=request.getParameter("page");
		String limitstr=request.getParameter("limit");
		String infoTitle=request.getParameter("infoTitle");
		User users=new User();
		if (user.length()!=0) {
			users=JSON.parseObject(user,User.class);
		}
		int page=Integer.parseInt(pagestr);
		int limit=Integer.parseInt(limitstr);
		PageBounds pb = new PageBounds(page,limit);
		return iCommunityService.getCommunityMsType(users,typeName,pb,infoTitle);
	}
	@RequestMapping(value="changeReadStatus.do")
	@ResponseBody
	public Integer changeReadStatus(String communityInfoReadStr){
		CommunityInfoRead communityInfoRead=JSON.parseObject(communityInfoReadStr,CommunityInfoRead.class);
		Integer status=iCommunityService.changeReadStatus(communityInfoRead);
		return status;
	}
	@RequestMapping(value="getReadCount.do")
	@ResponseBody
	public Integer getReadCount(String communityInfoReadStr){
		CommunityInfoRead communityInfoRead=JSON.parseObject(communityInfoReadStr,CommunityInfoRead.class);
		Integer status=iCommunityService.getReadCount(communityInfoRead);
		return status;
	}
	
	@RequestMapping(value="getUnlessCount.do")
	@ResponseBody
	public Integer getUnlessCount(String user){
		User users=JSON.parseObject(user,User.class);
		return iCommunityService.getunlessMsgCount(users);
	}
}
