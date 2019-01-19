package com.asiainfo.abdinfo.controller.readClock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.Book;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.service.linkageHomeService;

@Controller
public class LinkageController {
	
	@Autowired
	private linkageHomeService inkageHomeService;
	
	@RequestMapping(value="Linkage.do")
	public void Linkage(HttpServletRequest request,HttpServletResponse response){
		//获取二级联动状态 用来获取书单
	//	String linkState=request.getParameter("linkState");  
		//获取最开始展示数据章节
		//String linkChapter=request.getParameter("chapterState");		
		String staffCode=request.getParameter("staffCode");
		Map<String, String> map=new HashMap<String,String>();
		map.put("staffCode", staffCode);
//		map.put("linkState", linkState);
//		map.put("linkChapter", linkChapter);
		 List<ReadClock> re=inkageHomeService.getLinkage(map);
		 System.out.println(re);
		ResponseUtils.renderJson(response, JsonUtils.toJson(re));
	}
	

	

}
