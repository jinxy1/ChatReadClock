package com.asiainfo.abdinfo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.abdinfo.po.Calendar;
import com.asiainfo.abdinfo.po.Community;
import com.asiainfo.abdinfo.service.impl.CommunityServiceImple;

public class TestDate {

	@Test
	public void test() {
		CommunityServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("communityServiceImple", CommunityServiceImple.class);
		System.out.println();
		mlcvp.getDepID("18060405");


	}
	


	private String intConversion(int str) {
		if (str == 0) {
			return "";
		}
		int a = str / 60 / 60; // 时
		int b = str / 60 % 60; // 分
		int c = str % 60; // 秒
		String total = a + ":" + b + ":" + c;
		System.out.println(total);
		return total;
	}

	
}
