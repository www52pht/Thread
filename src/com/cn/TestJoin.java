package com.cn;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("vip来了！"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //线程启动
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            while (i == 200) {
                thread.join(); //插队
            }
            System.out.println("main"+i);
        }
    }
}
