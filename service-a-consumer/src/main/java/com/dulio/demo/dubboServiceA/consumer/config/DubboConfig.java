package com.dulio.demo.dubboServiceA.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:META-INF/dubbo/dubbo-consumer.xml"})
public class DubboConfig {

}