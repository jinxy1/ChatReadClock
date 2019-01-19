package com.asiainfo.abdinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.WorkPlan;

public interface WorkPlanService {
	public void addWorkPlan(List<WorkPlan> wlist);
	
	public void delwkl(String usercode,String nowdate);
	
	public List<WorkPlan> findnowday(String usercode,String nowday); 
	public int deleteById(Integer id);
}
