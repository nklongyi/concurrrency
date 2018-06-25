package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.NotThreadSafe;

/**
 * Created by longyi on 2018-06-25.
 */
//懒汉模式 -单例
@NotThreadSafe
public class sigletonExample1 {

    //私有构造函数
    private static void sigletonExample1(){

    }
    //初始化为空
    private static sigletonExample1 instance = null;

    public static sigletonExample1 getInstance(){
        if (instance ==null){
            instance = new sigletonExample1();
        }
        return instance;
    }
}
