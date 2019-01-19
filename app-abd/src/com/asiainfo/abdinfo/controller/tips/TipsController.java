package com.asiainfo.abdinfo.controller.tips;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.service.ITipsService;
@Controller
public class TipsController {
	
	@Resource
	private ITipsService tipsService;
	/**六项精进页面的添加请求*/
	@RequestMapping(value="/addtips.do")
	@ResponseBody
	public Map<String, Integer> addTips( HttpServletRequest request,HttpServletResponse response) throws ParseException{
		String department=request.getParameter("department");//部门
		String staffCode=request.getParameter("staffCode");//人员编码
		String tips=request.getParameter("tips");//今日感想等信息
		String menus=request.getParameter("menus");//感恩人的信息
		String time=request.getParameter("date");
		String customcontent=request.getParameter("customcontent");//自主填写内容
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		Date date=df.parse(time);*/
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("time",time);
		map.put("date",time);
		map.put("tips", tips);
		map.put("department", department);
		map.put("staffCode", staffCode);
		map.put("menus", menus);
		map.put("customcontent", customcontent);
		Map<String, Integer> numMap = new HashMap<String, Integer>();
		try {
			numMap = tipsService.addTipsDailyfeeling(map);
		} catch (Exception e) {
			numMap.put("num", 0);
			e.printStackTrace();
			return numMap;
			
		}
		return numMap;
	}
	
	/**查询所有人的姓名信息用于模糊查询*/
	@RequestMapping(value="/show.do")
	@ResponseBody
	public void show(HttpServletRequest request,HttpServletResponse response){
		String staffCode=(String)request.getParameter("staffCode");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		List<User> b=tipsService.findTips(map);
		/*List<String> namelist=new ArrayList<String>();
		for (User u : b) {
			namelist.add(u.getStaffName());
		}*/
		ResponseUtils.renderJson(response, JsonUtils.toJson(b));
		
	}
	
	/**删除感恩人信息*/
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public void delete(HttpServletRequest request,HttpServletResponse response){
		String idstr=request.getParameter("id");
		Integer id= Integer.parseInt(idstr);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",id);
		tipsService.deleteTipsOwes_content(map);
		
	}
}







