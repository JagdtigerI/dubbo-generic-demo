package com.dulio.demo.dubboServiceA.api;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Service
@Path("user")
public interface UserService {
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUser(@PathParam("id") String id);
}