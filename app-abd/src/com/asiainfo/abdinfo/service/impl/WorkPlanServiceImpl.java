package com.asiainfo.abdinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.WorkPlanMapper;
import com.asiainfo.abdinfo.po.WorkPlan;
import com.asiainfo.abdinfo.service.WorkPlanService;
import com.ibm.db2.jcc.am.de;
@Service("WorkPlanService")
public class WorkPlanServiceImpl implements WorkPlanService{
	@Resource
	private WorkPlanMapper wpmapper;

	@Override
	public void addWorkPlan(List<WorkPlan> wlist) {
		// TODO Auto-generated method stub
		for (WorkPlan workPlan : wlist) {
			wpmapper.addWorkPlan(workPlan);
		}
	}

	@Override
	public void delwkl(String usercode, String nowdate) {
		// TODO Auto-generated method stub
		try {
			wpmapper.delwkl(usercode, nowdate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<WorkPlan> findnowday(String usercode, String nowday) {
		// TODO Auto-generated method stub
		return wpmapper.findnowday(usercode, nowday);
	}

	@Override
	public int deleteById(Integer id) {
		return wpmapper.deleteById(id);
	}

}
