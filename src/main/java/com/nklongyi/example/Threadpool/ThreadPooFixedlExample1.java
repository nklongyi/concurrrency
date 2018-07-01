package com.nklongyi.example.Threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longyi on 2018-06-29.
 */
@Slf4j
public class ThreadPooFixedlExample1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i =0;i<10;i++){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task:{}",index);
                }
            });
        }

        executorService.shutdown();
    }
}
