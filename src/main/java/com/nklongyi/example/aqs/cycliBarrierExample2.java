package com.nklongyi.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * cyclicBarrier
 * Created by longyi on 2018-06-28.
 */
@Slf4j
public class cycliBarrierExample2 {
    private static int threadCount =20;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        log.info("call back is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);//允许20个线程

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();//关闭线程池,会让当前运行的线程执行完毕后再执行
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        cyclicBarrier.await();
        log.info("{} is continue",threadNum);
    }

}
