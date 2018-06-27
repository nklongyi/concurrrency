package com.nklongyi.example.sigleton;

import com.nklongyi.annotation.Recommend;
import com.nklongyi.annotation.ThreadSafe;

/**
 * 枚举模式
 * Created by longyi on 2018-06-25.
 */
//
@ThreadSafe
@Recommend
public class sigletonExample6 {
    //私有构造函数
    private static void sigletonExample1(){

    }
    public static sigletonExample6 getInstance(){
        return Sigleton.INSTANCE.getInstance();
    }
    private enum Sigleton{
        INSTANCE;
        private sigletonExample6 sigleton;
        //JVM保证这个方法绝对只调用一次
        Sigleton(){
            sigleton = new sigletonExample6();
        }
        public sigletonExample6 getInstance(){
            return sigleton;
        }
    }
}
