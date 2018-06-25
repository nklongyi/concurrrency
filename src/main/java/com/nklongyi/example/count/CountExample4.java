package com.nklongyi.example.count;

import com.nklongyi.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by longyi on 2018-06-25.
 */
@ThreadSafe
public class CountExample4 {

    private static AtomicReference<Integer> count = new AtomicReference(0);
    /**
     *
     */
    public static void main(String[] args){
       count.compareAndSet(0,2);
       count.compareAndSet(0,1);
       count.compareAndSet(1,3);
       count.compareAndSet(2,4);
       count.compareAndSet(4,5);
        System.out.println("count:"+count.get());
    }
}
