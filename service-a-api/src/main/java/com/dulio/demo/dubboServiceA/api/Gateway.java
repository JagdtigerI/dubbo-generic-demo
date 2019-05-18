package com.dulio.demo.dubboServiceA.api;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Service
@Path("gateway")
public interface Gateway {
    @GET
    @Path("route")
    @Produces({MediaType.APPLICATION_JSON})
    Object invoke();
}
