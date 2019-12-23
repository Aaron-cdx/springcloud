package com.duanxi.servicefeign.controller;

import com.duanxi.servicefeign.service.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoduanxi
 * @Date 2019/12/23 16:06
 */
@RestController
public class FeignController {
    @Autowired
    private ScheduleServiceHi scheduleServiceHi;
    // 通过feign调用微服务中部署的其他的服务的话只需要提供一个接口即可，@FeignClient内部使用动态代理实现
    @RequestMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayHiFromClientOne(name);
    }
}
