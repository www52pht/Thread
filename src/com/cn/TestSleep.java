package com.cn;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        //获取系统当前时间
        Date date = new Date(System.currentTimeMillis());

        while (true) {
            //睡眠一秒
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            //更新系统当前时间
            date = new Date(System.currentTimeMillis());
        }
    }
}
