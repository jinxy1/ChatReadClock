package com.asiainfo.abdinfo.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.dao.CommunityDao;
import com.asiainfo.abdinfo.po.Community;

public class TestMethod {
	

	
	@Test
	public void Test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CommunityDao Dao= (CommunityDao) context.getBean("CommunityDao");
	
		System.out.println(context);
		Community comm=new Community();
		comm.setContent("1");
		comm.setTitle("232");
		comm.setStaffCode("18060405");
		System.out.println(comm.getId());
		Dao.insertCommunit(comm);
		System.out.println(comm.getId());
		
	}
	
	
	

}
