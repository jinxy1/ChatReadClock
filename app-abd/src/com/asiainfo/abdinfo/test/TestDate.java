package com.asiainfo.abdinfo.test;

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
		System.out.println(ac);
		mlcvp = ac.getBean("communityServiceImple", CommunityServiceImple.class);
		List<String> aa=mlcvp.getTypeName("18060405");
		System.out.println(aa);
	}
	



	@Test
	public void Test1(){
		KillProcessImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("killProcessService", KillProcessImple.class);
		mlcvp.killProcess();
		System.out.println(ac);
	}
	
		
		
	}
	

	
	
	
	

	
	



