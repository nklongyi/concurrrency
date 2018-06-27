package com.nklongyi.example.threadLocals;

/**
 * Created by longyi on 2018-06-26.
 */
public class TestExample1 {
    //定义2个线程本地变量
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longLocal.get();
    }
    public String  getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TestExample1 testExample1 = new TestExample1();

        testExample1.set();
        System.out.println(testExample1.getLong());
        System.out.println(testExample1.getString());

        Thread thread1 = new Thread(){
            public void run(){
                testExample1.set();
                System.out.println(testExample1.getLong());
                System.out.println(testExample1.getString());
            };
        };

        thread1.start();
        thread1.join();

        System.out.println(testExample1.getLong());
        System.out.println(testExample1.getString());


    }
}
