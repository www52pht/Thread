package com.cn;

public class Race implements Runnable {

private String winner;

    @Override
    public void run() {

        for (int j = 0; j<= 100; j++) {
            if (Thread.currentThread().getName().equals("兔子")&& j%10==0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag=gameOver(j);
            //如果比赛结束，就停止程序
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+j+"步");
        }

    }

    public boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        else
        {
            if (steps >=100) {
                winner=Thread.currentThread().getName();
                System.out.println("winner是"+winner);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }


}
