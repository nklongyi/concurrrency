package com.nklongyi.example.sync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longyi on 2018-06-25.
 */

public class SynchronizedExample1 {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for (int i =0;i<10;i++){
                System.out.println("test1"+j+" result:" + i );
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(int j){
        for (int i =0;i<10;i++){
            System.out.println("test2 ---"+j + "result:" + i);
        }
    }

    /**
     *
     */
    public static void main(String[] args){
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            example1.test1(1);
        });
        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
