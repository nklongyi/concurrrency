package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.ThreadSafe;

/**
 * Created by longyi on 2018-06-25.
 */
//懒汉模式 -单例
@ThreadSafe
public class sigletonExample3 {

    //私有构造函数
    private static void sigletonExample1(){

    }
    //初始化为空
    private static sigletonExample3 instance = null;
    //
    //性能上开销较大，不推荐这种用法
    public static synchronized sigletonExample3 getInstance(){
        if (instance ==null){
            instance = new sigletonExample3();
        }
        return instance;
    }
}
