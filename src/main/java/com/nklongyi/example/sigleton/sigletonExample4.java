package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.ThreadSafe;

/**
 * Created by longyi on 2018-06-25.
 */
//懒汉模式 -单例 双重锁机制并不是指令安全
@ThreadSafe
public class sigletonExample4 {

    //私有构造函数
    private static void sigletonExample1(){

    }
    //1.分配对象内存空间
    //2.instance初始化对象
    //3.instance指向刚分配的内存
    //多线程环境下，JVM和CPU优化，指令重排1-3-2可能。
    //初始化为空
    private static sigletonExample4 instance = null;
    //
    //性能上开销较大，不推荐这种用法
    public static  sigletonExample4 getInstance(){
        if (instance ==null){ // Thread-B
            synchronized (sigletonExample4.class){
                if(instance == null){
                    instance = new sigletonExample4();//Thread-A
                }
            }
        }
        return instance;
    }
}
