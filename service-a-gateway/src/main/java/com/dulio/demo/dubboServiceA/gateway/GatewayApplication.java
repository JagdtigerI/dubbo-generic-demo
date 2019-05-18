package com.dulio.demo.dubboServiceA.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.dulio.demo.dubboServiceA.gateway"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@Import(value = {ServiceApplicationContext.class})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}