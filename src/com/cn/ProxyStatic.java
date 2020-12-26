package com.cn;

/*
 * 静态代理模式总结：
 * 1、真实对象跟代理对象都要实现同一个接口
 * 2、代理对象要代理真实角色
 *
 * 好处：
 *     代理对象可以做很多真实对象做不了的事情
 *     真实对象专注做自己的事情
 * */
public class ProxyStatic {

    public static void main(String[] args) {
//        You you = new You();//真实对象
//        WeddingComopany weddingComopany = new WeddingComopany(you);
//        weddingComopany.HappyMarry();
        new WeddingComopany(new You()).HappyMarry();//这一句等于上面的注释三句话
        new Thread(()-> System.out.println("我爱你")).start();  //接下来就是静态代理类比一下实现runnable接口的Thread
    }
}


interface Marry {
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("我结婚了！超开心");
    }
}

//代理角色，帮助你结婚
class WeddingComopany implements Marry {

    //代理谁呢--》》真实目标角色
    private Marry target;

    public WeddingComopany() {
    }

    public WeddingComopany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后收钱很痛苦");
    }

    private void before() {
        System.out.println("结婚前布置现场");
    }
}
