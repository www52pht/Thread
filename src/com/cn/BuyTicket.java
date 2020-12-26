package com.cn;

import javax.naming.Name;

public class BuyTicket implements Runnable {

    private int ticketname = 12;


    @Override
    public void run() {
        while (true) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    private void buy() throws InterruptedException {
        synchronized (this) {
            if (ticketname <= 0) {
                return;
            }
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketname-- + "张票");

        }

    }

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "小明").start();
        new Thread(buyTicket, "猪头").start();
        new Thread(buyTicket, "黄牛党").start();


    }

}