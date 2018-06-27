package com.nklongyi.example.SyncContainer;

import com.google.common.collect.Lists;
import com.nklongyi.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by longyi on 2018-06-27.
 */
@Slf4j
public class CollectionsExample3 {

    // java.util.ConcurrentModificationException
  public static void test1(Vector<Integer> vector){ //for each
      for (Integer i:vector) {
          if (i.equals(3)){
              vector.remove(i);
          }
      }
  }
//java.util.ConcurrentModificationException
  public static void test2(Vector<Integer> vector){//迭代器
      Iterator<Integer> iterator = vector.iterator();
      while(iterator.hasNext()){
          Integer i = iterator.next();
          if(i.equals(3)){
              vector.remove(i);
          }
      }
  }

  //success
  public static void test3(Vector<Integer> vector){
      for (int i = 0; i <vector.size() ; i++) {
          if(vector.get(i).equals(3)){
              vector.remove(i);
          }
      }
  }


    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }



}
