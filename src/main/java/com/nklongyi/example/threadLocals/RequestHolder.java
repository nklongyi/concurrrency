package com.nklongyi.example.threadLocals;

/**
 * Created by longyi on 2018-06-26.
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<Long>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    //必须remove，否则会出现内存泄露
    public static void remove(){
        requestHolder.remove();
    }

}
