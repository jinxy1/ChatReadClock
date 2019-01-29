package com.asiainfo.abdinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.PlanDao;
import com.asiainfo.abdinfo.po.DayPlan;
import com.asiainfo.abdinfo.po.PlanRecord;
import com.asiainfo.abdinfo.service.PlanDaoService;

/**
 * 日计划
 * @author jxy
 *
 */
@Service("PlanDaoService")
public class PlanDaoServiceImple implements PlanDaoService{
	
	@Autowired
	private PlanDao planDao;

	@Override
	public List<DayPlan> makePlan(String staffCode) {
		return planDao.makePlan(staffCode);
	}

	@Override
	public void insertPlanRecord(String staffCode, String planTime, List<PlanRecord> list) {
		planDao.insertPlanRecord(staffCode, planTime, list);
	}

}
