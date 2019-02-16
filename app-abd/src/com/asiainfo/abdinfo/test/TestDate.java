package com.asiainfo.abdinfo.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.abdinfo.po.Calendar;
import com.asiainfo.abdinfo.service.impl.LinkageHomeImple;

public class TestDate {

	@Test
	public void test() {
		LinkageHomeImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("linkageHomeService", LinkageHomeImple.class);
		long startTime=System.currentTimeMillis();
		List<Calendar> a=mlcvp.selectCalendarContent("18060405","2019-02-14");
		long endTime=System.currentTimeMillis();
		System.out.println(startTime+endTime);
		System.out.println(ac);
		System.out.println(a);

	}

	
	
	@Test
	public void test1(){
		
		boolean flag=true;
		while(flag){
			System.out.println("fdkjfhjkd");
			flag=false;
		}
	}
	
	@Test
	public void test3(){
	String a="24:05:30"	;
	String b="11:05:06";
	System.out.println(a+b);
	//dateConversion(a);
	int c=0;
	intConversion(c);
	}
	
	private String intConversion(int str){
		if(str==0){
			return "";
		}
		int a=str/60/60;    //时
		int b=str/60%60;    //分
		int c=str%60;       //秒
		String total=a+":"+b+":"+c;
		System.out.println(total);
		return total;
	}
	
	
	
/*	private int dateConversion(String str){
		int a=Integer.parseInt(str.substring(0,2))*60*60;
		int b =Integer.parseInt(str.substring(3,5))*60;
		int c=Integer.parseInt(str.substring(6,8));
		int tatal=a+b+c;
		System.out.println(tatal);
		return tatal;
	}*/
	
	
	/*@Test
	public void test2(){
		ReadClockImple mlcvp;
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
		mlcvp = ac.getBean("ReadClockService", ReadClockImple.class);
		
	}*/
	
	

	

	}

















