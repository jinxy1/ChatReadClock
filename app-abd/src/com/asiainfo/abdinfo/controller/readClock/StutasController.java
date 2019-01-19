package com.asiainfo.abdinfo.controller.readClock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.NewLoginBean.ListAllFeeling;
import com.asiainfo.abdinfo.service.IStutasService;

@Controller
public class StutasController {
	@Resource
	private IStutasService stutasService;
	
	@RequestMapping(value="/addStutas.do")
	@ResponseBody
	public void stutas(HttpServletRequest request,HttpServletResponse response){
		String stutas=request.getParameter("stutas");
		JSONArray jsonArray=JSONArray.parseArray(stutas);
		System.out.println(jsonArray.size());
		String result="";
		if (jsonArray!=null) {
			for (Object object : jsonArray) {
				String str=object.toString();
				ListAllFeeling listAllFeeling=JSON.parseObject(str,ListAllFeeling.class);
				System.out.println(listAllFeeling+"这是获取的数据");
				stutasService.addStutas(listAllFeeling);
			}
		}
		ResponseUtils.renderJson(response, result);
	}
	
	@RequestMapping(value="/enshrines.do")
	@ResponseBody 
	public List<ListAllFeeling> enshrines(HttpServletRequest request,HttpServletResponse response){
		String staffCode=request.getParameter("staffCode");
		System.out.println(staffCode);
		List<ListAllFeeling> list=stutasService.selectEnshrines(staffCode);
		/*JSONArray jsonArray=JSONArray.;
		ResponseUtils.renderJson(response, );*/
		return list;
	}
	
	@RequestMapping(value="/deleteEnshrine.do")
	@ResponseBody 
	public int deleteEnshrines(HttpServletRequest request,HttpServletResponse response){
		String idstr=request.getParameter("id");
		int id=Integer.parseInt(idstr);
		Map<String, Object> map= new HashMap<String ,Object>();
		map.put("id", id);
		return stutasService.deleteEnshrineById(map);
	}
	
	
}
