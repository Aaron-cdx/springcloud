package com.duanxi.serviceribbon.controller;

import com.duanxi.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoduanxi
 * @Date 2019/12/23 15:46
 */
@RestController
public class HiController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
