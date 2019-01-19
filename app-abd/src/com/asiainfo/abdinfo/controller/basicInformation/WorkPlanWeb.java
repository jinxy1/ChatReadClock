package com.asiainfo.abdinfo.controller.basicInformation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.JBoss6VFS;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.Personnel;
import com.asiainfo.abdinfo.po.WorkPlan;
import com.asiainfo.abdinfo.service.PerService;
import com.asiainfo.abdinfo.service.WorkPlanService;

@Controller
public class WorkPlanWeb {
	@Resource
	private WorkPlanService wps;
	@Resource
	private PerService perService;
	
	@RequestMapping(value="/addworkplan.do")
	public void addworkplan(HttpServletRequest request,HttpServletResponse response,/**String  部门,
			String  Username,*/String  usercode,String nowday,String workplan){
		System.out.println(workplan);
		Personnel per=perService.findByCode(usercode);
		System.out.println(per);
		JSONArray json = JSON.parseArray(workplan);
		Iterator it = json.iterator();
		List<WorkPlan> list=new ArrayList<WorkPlan>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current=sdf.format(new Date());
		while (it.hasNext()) {
			WorkPlan workPlan=new WorkPlan();
			JSONObject sObj = (JSONObject)it.next();
			String name=sObj.getString("name");
			workPlan.setStaffCode(per.getUsercode());
			workPlan.setStaffName(per.getUsername());
			workPlan.setDepartment(per.getDepartment());
			workPlan.setDate(nowday);
			workPlan.setActconcom(name);
			workPlan.setCreateDate(current);
			list.add(workPlan);
		}
		/*try {
		 */
			wps.delwkl(usercode,nowday);
			wps.addWorkPlan(list);
			ResponseUtils.renderJson(response, JsonUtils.toJson("提交成功"));
		/*} catch (RuntimeException e) {
			// TODO: handle exception
			ResponseUtils.renderJson(response, JsonUtils.toJson("提交失败"));
		}*/
	}
	@RequestMapping("/findnowdayplan.do")
	public void findnowdayplan(HttpServletRequest request,HttpServletResponse response,String usercode,String nowday){
		List<WorkPlan> list=wps.findnowday(usercode, nowday);
		ResponseUtils.renderJson(response, JsonUtils.toJson(list));
	}
	
	@RequestMapping("/deleteById.do")
	public void deleteById(HttpServletRequest request,HttpServletResponse response){
		String idstr=request.getParameter("id");
		Integer id=Integer.parseInt(idstr);
		int rusult=wps.deleteById(id);
	}
}

