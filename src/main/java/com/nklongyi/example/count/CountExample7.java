package com.nklongyi.example.count;

import com.nklongyi.annotation.NotThreadSafe;
import com.nklongyi.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by longyi on 2018-06-25.
 */
@NotThreadSafe
public class CountExample7 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static volatile int  count = 0;

    /**
     *
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:"+count);

    }

    private static void add(){
        count++;
    }

}
