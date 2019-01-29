package com.asiainfo.abdinfo.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.po.BaseInformation;
import com.asiainfo.abdinfo.service.impl.NewLoginImple;
import com.asiainfo.abdinfo.service.impl.PlanDaoServiceImple;
import com.asiainfo.abdinfo.service.impl.ReadClockImple;
import com.asiainfo.abdinfo.service.impl.SixDiligenceServiceImpl;

public class TestDate {

	@Test
	public void checser() {
		
	}

	@Test
	public void test2() {
	
	}

	@Test
	public void test3() {
		
	}

	
	@Test
	public void test4() {
		PlanDaoServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("PlanDaoService", PlanDaoServiceImple.class);
	    String staffCode="18060405";
	    String planTime="2019-01-28";
	   // [{"type":"系统研发","projectName":"微信小程序开发","timeLong":0.3,"planContent":"fdf"},{"type":"系统研发","projectName":"微信小程序开发","timeLong":0.3,"planContent":"fd"}]
	    
	//	mlcvp.insertPlanRecord(staffCode, planTime, list);
		
	
	}


	

	}

















