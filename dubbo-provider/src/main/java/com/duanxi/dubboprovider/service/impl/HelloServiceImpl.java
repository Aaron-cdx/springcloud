package com.duanxi.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.duanxi.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author caoduanxi
 * @Date 2019/12/28 21:27
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
