package com.asiainfo.abdinfo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.service.impl.CommunityServiceImple;
import com.asiainfo.abdinfo.service.impl.KillProcessImple;

public class TestDate {

	@Test
	public void test() {
		CommunityServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("communityServiceImple", CommunityServiceImple.class);
		System.out.println();

		List a=new ArrayList<String>();
		a.add("华东部");
		a.add("18060407");
		a.add("高中升学辅导事业二部");
	

	}
	



	@Test
	public void Test1(){
		KillProcessImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("killProcessService", KillProcessImple.class);
		mlcvp.killProcess();
	}
	
		
		
	}
	

	
	
	
	

	
	



