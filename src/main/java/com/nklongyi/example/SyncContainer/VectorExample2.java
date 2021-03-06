package com.nklongyi.example.SyncContainer;

import com.nklongyi.annotation.NotThreadSafe;
import com.nklongyi.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by longyi on 2018-06-27.
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {
    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws InterruptedException {

        while (true){
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread thread1 = new Thread(){
                public void run(){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread(){
                public void run(){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }
}
