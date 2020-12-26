package com.cn;

public class Lambda {

    //3、静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("lambda2");
        }
    }

    //


    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4、局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("lambda3");
            }
        }

        like = new Like3();
        like.lambda();


        //5、匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("lambda4");
            }
        };

        like.lambda();


        //6、用lambda简化
        like = () -> System.out.println("lambda5");

        like.lambda();
    }

}

//定义函数式接口
interface ILike {
    void lambda();
}

//实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("lambda1");
    }
}
