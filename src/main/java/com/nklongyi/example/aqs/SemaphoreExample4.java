package com.nklongyi.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 * Created by longyi on 2018-06-28.
 */
@Slf4j
public class SemaphoreExample4 {
    private static int threadCount =20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);//允许20个线程

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    if (semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)){//尝试获取许可
                        test(threadNum);
                        semaphore.release();//释放3个许可
                    }//如果没有许可，就丢弃
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();//关闭线程池,会让当前运行的线程执行完毕后再执行
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
