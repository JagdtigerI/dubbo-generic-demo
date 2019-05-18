package com.dulio.demo.dubboServiceA.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.dulio.demo.dubboServiceA.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@Import(value = {ServiceApplicationContext.class})
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}