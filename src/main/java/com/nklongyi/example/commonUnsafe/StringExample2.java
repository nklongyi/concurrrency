package com.nklongyi.example.commonUnsafe;

import com.nklongyi.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * StringBuffer是线程安全的类
 */
@ThreadSafe
public class StringExample2 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static StringBuffer stringBuffer = new StringBuffer();

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
        System.out.println("size:{}:"+stringBuffer.length());
    }

    private static void update(){
        stringBuffer.append("1");
    }

}
