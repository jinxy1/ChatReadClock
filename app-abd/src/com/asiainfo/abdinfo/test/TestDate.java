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
		ReadClockImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("ReadClockService", ReadClockImple.class);
	    
		
		
	
	}


	

	}

















