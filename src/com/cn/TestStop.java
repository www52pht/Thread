package com.cn;

/*
 * 1、建议线程正常停止--》利用次数，不建议死循环
 * 2、建议使用标志位---》设置一个标志位
 * 3、不要使用stop或者destroy等过时方法或者JDK不建议使用的方法
 * */
public class TestStop implements Runnable {
    //设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run......Thread" + i++);
        }
    }

    public void Stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 904; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //调用stop方法切换标志位，让线程停止
                testStop.Stop();
                System.out.println("线程该停止了！");
            }
        }
    }
}
