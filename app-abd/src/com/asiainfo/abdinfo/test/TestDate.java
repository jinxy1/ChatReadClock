package com.asiainfo.abdinfo.test;



import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.po.PlanData;
import com.asiainfo.abdinfo.service.impl.PlanDaoServiceImple;

public class TestDate {

	@Test
	public void test() {
		PlanDaoServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("PlanDaoService", PlanDaoServiceImple.class);
	    String staffCode="18060405";
	    String planTime="2019-01-29";
	    List<PlanData>map=mlcvp.selectPlan(staffCode, planTime);
	    System.out.println(map);
		
	
	}


	

	}

















