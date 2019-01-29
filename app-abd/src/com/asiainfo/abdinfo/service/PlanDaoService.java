package com.asiainfo.abdinfo.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.asiainfo.abdinfo.po.DayPlan;
import com.asiainfo.abdinfo.po.PlanRecord;

/**
 * 日计划
 * @author jxy
 *
 */
public interface PlanDaoService {
	
	List<DayPlan> makePlan(@Param("staffCode") String staffCode);
	
	void insertPlanRecord( String staffCode,String planTime, List<PlanRecord> list);
}
