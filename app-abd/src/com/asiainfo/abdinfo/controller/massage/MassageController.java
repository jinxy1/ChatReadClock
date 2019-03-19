package com.asiainfo.abdinfo.controller.massage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.Massage;
import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.service.ICommunityService;
import com.asiainfo.abdinfo.service.IMassageService;
import com.asiainfo.abdinfo.service.IStutasService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;
/**信息流*/
@Controller
public class MassageController{
	
	@Resource
	private IMassageService iMassageService;
	@Resource
	private IStutasService stutasService;
	@Resource
	private ICommunityService communityService;
	/**查询信息流*/
	@RequestMapping(value="massage.do")
	@ResponseBody
	public void findMassage(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String staffCode=request.getParameter("staffCode");
		String pageStr=request.getParameter("page");
		int page=Integer.parseInt(pageStr);
		int limit=Integer.valueOf(request.getParameter("limit"));
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		Integer count=iMassageService.findCount(map);
		PageBounds pb = new PageBounds(page,limit);
		PageBean<Massage> massage=iMassageService.findMassage(map, pb);
		Map<String, Object> date = new HashMap<String,Object>();
		date.put("count", count);
		date.put("massage", massage);
		ResponseUtils.renderJson(response, JsonUtils.toJson(date));
	}
	/**更新信息流状态*/
	@RequestMapping(value="updateStutas.do")
	@ResponseBody
	public void updateMassage(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String staffCode=request.getParameter("staffCode");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		int date=iMassageService.updateMassage(map);
		ResponseUtils.renderJson(response, JsonUtils.toJson(date));
	}
	/**统计未读信息流个数*/
	@RequestMapping(value="massageCount.do")
	@ResponseBody
	public void findMassageCount(String user,HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String staffCode=request.getParameter("staffCode");
		User users=JSON.parseObject(user,User.class);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("staffCode", staffCode);
		Integer countMassage=communityService.getunlessMsgCount(users);
		Integer countFabulous=stutasService.selectFabulousNum(map);
		List<Integer> count=new ArrayList<Integer>();
		count.add(countMassage);
		count.add(countFabulous);
		ResponseUtils.renderJson(response, JsonUtils.toJson(count));
	}
	
}
