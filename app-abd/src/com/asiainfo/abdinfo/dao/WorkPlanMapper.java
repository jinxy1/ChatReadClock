package com.asiainfo.abdinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.WorkPlan;

public interface WorkPlanMapper {
	public void addWorkPlan(WorkPlan workplan);
	
	public void delwkl(@Param("usercode") String usercode,@Param("nowtime") String nowtime);
	
	public List<WorkPlan> findnowday(@Param("usercode") String usercode,@Param("nowday") String nowday);
	public int deleteById(@Param("id") Integer id);
}
