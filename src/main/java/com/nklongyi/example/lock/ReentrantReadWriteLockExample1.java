package com.nklongyi.example.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by longyi on 2018-06-25.
 */
public class ReentrantReadWriteLockExample1 {

  private final Map<String,Data> map = new TreeMap<>();

  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  private final Lock readLock = lock.readLock();

  private final Lock writeLock = lock.writeLock();

  public Data get(String key){
      readLock.lock();
      try{
          return map.get(key);
      }finally {
          readLock.unlock();
      }
  }
  class Data{

  }

}
