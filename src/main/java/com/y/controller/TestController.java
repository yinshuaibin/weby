package com.y.controller;

import com.y.bean.Authc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinshuaibin
 * @date 2020/6/18 9:38
 */
@RestController
public class TestController {

    @RequestMapping("/t1")
    public Object t1(){
        Authc a = new Authc();
        a.setAuthcId(1);
        a.setAuthcName("111");
        return a;
    }
}
