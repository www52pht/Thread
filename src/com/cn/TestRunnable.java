package com.cn;

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----" + i);
        }
    }

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();

        Thread thread = new Thread(testRunnable);

        thread.start();
    }
}
