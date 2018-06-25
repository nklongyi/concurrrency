package com.nklongyi.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对静态方法 静态类做synchronized处理，作用的对象是类的实例
 * Created by longyi on 2018-06-25.
 */

public class SynchronizedExample2 {

    //修饰一个代码类
    public void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i =0;i<10;i++){
                System.out.println("test1"+j+" result:" + i );
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(int j){
        for (int i =0;i<10;i++){
            System.out.println("test2 ---"+j + "result:" + i);
        }
    }

    /**
     *
     */
    public static void main(String[] args){
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            example1.test1(1);
        });
        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
