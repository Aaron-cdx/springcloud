package com.duanxi.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 主要是用于发现已经注册的client
@EnableEurekaClient
@EnableHystrix // 开启熔断器
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xxx");
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡！
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
