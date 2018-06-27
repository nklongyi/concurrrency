package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.ThreadSafe;

/**
 * Created by longyi on 2018-06-25.
 */
//饿汉模式 -单例，在类加载阶段就加载实例,线程安全（通过静态块的形式）.
@ThreadSafe
public class sigletonExample5 {
    //私有构造函数
    private static void sigletonExample1(){

    }
    //初始化为空
    private static sigletonExample5 instance = null;

    static {
        instance = new sigletonExample5();
    }

    public static sigletonExample5 getInstance(){
        return instance;
    }
}
