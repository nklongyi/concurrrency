package com.nklongyi.example.sigleton;

/**
 * Created by longyi on 2018-06-25.
 */
//懒汉模式 -单例
public class sigletonExample3 {

    //私有构造函数
    private static void sigletonExample1(){

    }
    //初始化为空
    private static sigletonExample3 instance = null;

    public static sigletonExample3 getInstance(){
        if (instance ==null){
            instance = new sigletonExample3();
        }
        return instance;
    }
}
