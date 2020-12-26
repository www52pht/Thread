package com.cn;

public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        Thread thread = new Thread(new MyPriority(), "线程1");
        thread.start();
        Thread thread1 = new Thread(new MyPriority(), "线程2");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
    }

}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}