package com.nklongyi.example.publish;

import com.nklongyi.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by longyi on 2018-06-26.
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafepublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafepublish.getStates()));

        unsafepublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafepublish.getStates()));

    }
}
