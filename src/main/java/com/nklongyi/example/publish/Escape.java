package com.nklongyi.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by longyi on 2018-06-26.
 */
@Slf4j
public class Escape {
    private int thisCanBeEscape = 0;

    //对象未初始化完成，就开启新的线程去创造对象；
    //而对象中又对this进行了引用，很容易造成this空指针
    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
