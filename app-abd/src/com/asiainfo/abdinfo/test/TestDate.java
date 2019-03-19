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
import com.asiainfo.abdinfo.service.impl.LinkageHomeImple;
import com.asiainfo.abdinfo.service.impl.ReadClockImple;

public class TestDate {

	@Test
	public void test() {
		CommunityServiceImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("communityServiceImple", CommunityServiceImple.class);
		System.out.println();
		mlcvp.getDepID("18060405");
	}

	
	@Test
	public void test1() {
		boolean flag = true;
		int i = 1;
		while (flag) {
			System.out.println("fdkjfhjkd");
			i++;
			if (i > 10) {
				break;
			}
		}
	}

	@Test
	public void test3() {
		String a = "24:05:30";
		String b = "11:05:06";
		System.out.println(a + b);
		// dateConversion(a);
		int c = 0;
		intConversion(c);
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

	@Test
	public void test4() {
		String a = "start,start,startHref";
		a.split(",");
		System.out.println(a.split(","));
	}

}
