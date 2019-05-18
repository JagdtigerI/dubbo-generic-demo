package com.dulio.demo.dubboServiceA.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:META-INF/dubbo/dubbo-provider.xml"})
public class DubboConfig {

}