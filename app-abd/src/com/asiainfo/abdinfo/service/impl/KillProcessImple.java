package com.asiainfo.abdinfo.service.impl;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Service;
import com.asiainfo.abdinfo.service.KillProcessService;





@Service("killProcessService")
public class KillProcessImple implements KillProcessService{

	@Override
	public void killProcess() {
		// TODO Auto-generated method stub
		   //创建定时器对象
        Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法
        t.schedule(new MyTask(), 3000,2000);
		
	}


	
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("您该起床了!!!!");
    }
}


