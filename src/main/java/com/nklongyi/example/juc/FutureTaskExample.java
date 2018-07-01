package com.nklongyi.example.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by longyi on 2018-06-29.
 */
@Slf4j
public class FutureTaskExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do someting in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
          @Override
          public String call() throws Exception {
              log.info("do someting in callable");
              Thread.sleep(5000);
              return "Done";
          }
      });
      new Thread(futureTask).start();
      log.info("do something in main");
      Thread.sleep(1000);
      String result = futureTask.get();
      log.info("result:{}",result);
    }
}
