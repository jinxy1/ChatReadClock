package com.asiainfo.abdinfo.test;


import org.junit.Test;

public class TestDate {

	@Test
	public void test() {
//		CommunityServiceImpl mlcvp;
//		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml", "conf/spring-mybatis.xml");
//		mlcvp = ac.getBean("communityServiceImpl", CommunityServiceImpl.class);
//		System.out.println(ac);
		//int a=mlcvp.changeReadStatus("18060404","1");
		//System.out.println(a);
		


	}

	
	
	@Test
	public void test1(){
		
		boolean flag=true;
		int i=1;
		while(flag){
			System.out.println("fdkjfhjkd");
			i++;
			if(i>10){
				break;
			}
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
	
	
	
	@Test
    public void test4(){
    	String a="start,start,startHref";
    	a.split(",");
    	System.out.println(a.split(","));
    }
	
	

	

	}

















