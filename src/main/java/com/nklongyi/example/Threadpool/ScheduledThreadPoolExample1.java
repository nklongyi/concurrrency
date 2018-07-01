package com.nklongyi.example.Threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by longyi on 2018-06-29.
 */
@Slf4j
public class ScheduledThreadPoolExample1 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("schedule run");
//            }
//        },3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        },1,3,TimeUnit.SECONDS);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("time run");
            }
        },new Date(),5*1000);
    }
}
