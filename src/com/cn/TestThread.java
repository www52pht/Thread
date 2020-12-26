package com.cn;

public class TestThread extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----" + i);
        }
    }

    public static void main(String[] args) {

        //创建一个线程对象；
        TestThread testThread = new TestThread();
        //调用start方法
        testThread.start();
        //main线程。主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程----" + i);
        }
    }
}
