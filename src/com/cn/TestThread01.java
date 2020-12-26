package com.cn;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread01 extends Thread {
    private String url;
    private String name;

    public TestThread01(String url, String name) {
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
        TestThread01 testThread01 = new TestThread01("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1608448720&di=ca6fe2fb67cfaead506b96e2afd27bd4&src=http://a0.att.hudong.com/52/62/31300542679117141195629117826.jpg", "小黄图.jpg");
        testThread01.start();
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
