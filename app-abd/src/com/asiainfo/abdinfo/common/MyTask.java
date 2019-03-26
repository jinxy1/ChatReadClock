package com.asiainfo.abdinfo.common;


import java.util.Timer;
import java.util.TimerTask;

class MyTask1 extends TimerTask{

    @Override
    public void run() {
        System.out.println("您该起床了!!!!");
    }
}

public class MyTask {
    public static void main(String[] args) {
        //创建定时器对象
        Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法
        t.schedule(new MyTask1(), 3000,2000);
    }
}