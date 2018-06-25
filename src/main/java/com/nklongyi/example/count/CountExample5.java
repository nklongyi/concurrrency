package com.nklongyi.example.count;

import com.nklongyi.annotation.ThreadSafe;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by longyi on 2018-06-25.
 */
@ThreadSafe
public class CountExample5 {

   private static AtomicIntegerFieldUpdater<CountExample5> updater = AtomicIntegerFieldUpdater.newUpdater(CountExample5.class,"count");


   public volatile int count = 100;

   private static CountExample5 example5 = new CountExample5();



    public static void main(String[] args){
        if(updater.compareAndSet(example5,100,120)){
            System.out.println("update success 1 "+example5);
        }
        if(updater.compareAndSet(example5,120,100)){
            System.out.println("update success 1 "+example5);
        }else {
            System.out.println("update failed:" + example5);
        }
    }
}
