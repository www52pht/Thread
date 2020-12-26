package com.cn;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/*callable好处
* 1、可以定义返回值
* 2、可以抛出异常*/

public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1608448720&di=ca6fe2fb67cfaead506b96e2afd27bd4&src=http://a0.att.hudong.com/52/62/31300542679117141195629117826.jpg", "小黄图.jpg");
        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //执行提交
        Future<Boolean> result1 = service.submit(t1);
        //获取结果
        Boolean r1 = result1.get();

        System.out.println(r1);
        service.shutdown();
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
