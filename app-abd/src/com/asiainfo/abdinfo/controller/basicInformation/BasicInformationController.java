package com.asiainfo.abdinfo.controller.basicInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ListObject;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.common.StatusCode;
import com.asiainfo.abdinfo.po.BaseInformation;
import com.asiainfo.abdinfo.service.BaseInformationService;

@Controller
public class BasicInformationController {
	

	@Autowired
	private BaseInformationService baseInformationService;
	
	@RequestMapping(value = "/basicInformation.do")
	public void find( HttpServletRequest request, HttpServletResponse response) {
		List<BaseInformation>   ba=baseInformationService.getBaseInformation();
		ListObject listObject = new ListObject();
		listObject.setItems(ba);
		listObject.setCode(StatusCode.CODE_SUCCESS);
		listObject.setMsg("访问成功");
		ResponseUtils.renderJson(response, JsonUtils.toJson(ba));
	}
	
	
	
	@RequestMapping(value = "/editor.do")
	public void findById( HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		Map map=new HashMap();
		map.put("id", id);
		List<BaseInformation>   ba=baseInformationService.getBaseInformation(map);
		ResponseUtils.renderJson(response, JsonUtils.toJson(ba));
	}
	
	@RequestMapping(value = "/remove.do")
	public void removeById( HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		baseInformationService.getDeleteBaseInformation(id);
		System.out.println("刪除成功");
	}
	
	@RequestMapping(value = "/add.do")
	public void addById( HttpServletRequest request, HttpServletResponse response) {
		String areaName= request.getParameter("areaName");
		String priority=request.getParameter("priority");
		baseInformationService.addBaseInformation(areaName, priority);
		System.out.println("刪除成功");
	}

}









