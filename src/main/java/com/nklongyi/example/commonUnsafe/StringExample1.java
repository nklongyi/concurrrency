package com.nklongyi.example.commonUnsafe;

import com.nklongyi.annotation.NotThreadSafe;
import com.nklongyi.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * StringBuilder 不是线程安全的类
 */
@NotThreadSafe
public class StringExample1 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static StringBuilder stringBuilder = new StringBuilder();

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
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("size:{}:"+stringBuilder.length());
    }

    private static void update(){
        stringBuilder.append("1");
    }

}
