package com.duanxi.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @author caoduanxi
 * @Date 2019/12/23 16:25、
 * <p>
 * 为了配合熔断策略的进行添加的如果调用服务失败采用的策略
 */
@Component
public class ScheduleServiceHystrix implements ScheduleServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name + ",the server meeting error-_-||";
    }
}
