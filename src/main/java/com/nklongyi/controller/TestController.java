package com.nklongyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by longyi on 2018-06-25.
 * 模拟并发测试
 */
@Controller
@ResponseBody
public class TestController {

    @RequestMapping("/test")
    public  String test(){
        return "test";
    }
}
