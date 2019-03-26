package com.asiainfo.abdinfo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.service.impl.CommunityServiceImple;

public class TestDate {

	@Test
	public void test() {
		CommunityServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("communityServiceImple", CommunityServiceImple.class);
		System.out.println();
//		mlcvp.getDepID("18060405");
		System.out.println(mlcvp);
		System.out.println(ac);

	}
	
}
