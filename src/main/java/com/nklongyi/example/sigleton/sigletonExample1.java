package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.NotThreadSafe;

/**
 * Created by longyi on 2018-06-25.
 */
//懒汉模式 -单例的实例在第一次使用的时候创建
@NotThreadSafe
public class sigletonExample1 {

    //私有构造函数
    private static void sigletonExample1(){

    }
    //单例对象
    private static sigletonExample1 instance = null;

    //静态的工厂方法
    public static sigletonExample1 getInstance(){
        if (instance ==null){ //在多线程环境下，对instance的判断可能存在偏差，导致多次实例化
            instance = new sigletonExample1();
        }
        return instance;
    }

}
