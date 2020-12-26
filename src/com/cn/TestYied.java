package com.cn;

//测试礼让线程
//礼让不一定能成功
public class TestYied {

    public static void main(String[] args) {
        MyYied myYied = new MyYied();
        new Thread(myYied, "小明").start();
        new Thread(myYied, "小黄").start();

    }

}

class MyYied implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程执行开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程执行结束");
    }
}
