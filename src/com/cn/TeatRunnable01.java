package com.cn;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TeatRunnable01 implements Runnable {
    private String url;
    private String name;

    public TeatRunnable01(String url, String name) {
        this.url = url;
        this.name = name;
    }



    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TeatRunnable01 teatRunnable01 = new TeatRunnable01("https://scpic.chinaz.net/files/pic/pic9/202012/apic29589.jpg","小黄图1.jpg");
        new Thread(teatRunnable01).start();
    }

    //下载器
    class WebDownloader {
        public void downloader(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常，downloader方法出现问题！");
            }
        }
    }
}
