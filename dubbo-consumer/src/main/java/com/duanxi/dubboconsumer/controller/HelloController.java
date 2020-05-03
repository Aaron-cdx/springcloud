package com.duanxi.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duanxi.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoduanxi
 * @Date 2019/12/28 21:33
 */
@RestController
public class HelloController {
    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("world!");
        System.out.println(helloService.sayHello("caoduanxi"));
        return hello;
    }
}
