package com.duanxi.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author caoduanxi
 * @Date 2019/12/23 16:01
 */

/**
 * fallback主要是为了满足hystrix的特性，一旦访问失败需要反馈点什么消息回去，需要将此服务调用熔断
 * 防止出现微服务系统"雪崩"现象的产生！
 */
@FeignClient(value = "service-hi", fallback = ScheduleServiceHystrix.class) // 表明自己需要调用的服务
public interface ScheduleServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
