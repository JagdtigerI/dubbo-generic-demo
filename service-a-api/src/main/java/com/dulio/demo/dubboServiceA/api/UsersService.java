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
@Path("users")
public interface UsersService {
    @GET
    @Path("{ids}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUsers(@PathParam("ids") String ids);
}