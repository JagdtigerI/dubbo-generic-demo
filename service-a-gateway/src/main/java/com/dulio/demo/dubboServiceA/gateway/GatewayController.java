package com.dulio.demo.dubboServiceA.gateway;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("gateway")
public class GatewayController {
    @RequestMapping(value = "route", method = RequestMethod.GET)
    @ResponseBody
    public Object route() {
        // 普通编码配置方式
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-gateway-proxy");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface("com.dulio.demo.dubboServiceA.api.UsersService");
        reference.setGeneric(true); // 声明为泛化接口

        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke("getUsers",
                new String[]{String.class.getName()},
                new Object[]{"1,2,3,4,5,6"});
        System.out.println(result);
        return result;
    }
}
