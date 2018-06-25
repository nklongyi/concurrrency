package com.nklongyi.example.count;

import com.nklongyi.annotation.ThreadSafe;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 如何让某一段代码只执行一次的示例
 *
 * Created by longyi on 2018-06-25.
 */
@ThreadSafe
public class CountExample6 {
    private static AtomicBoolean isHappened = new AtomicBoolean(false);


    public static int clientTotal = 5000;

    public static int threadTotal = 200;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("isHappend:"+isHappened.get());
    }

    private static void test(){
        if(isHappened.compareAndSet(false,true)){
            System.out.println("executed");
        }
    }


}
