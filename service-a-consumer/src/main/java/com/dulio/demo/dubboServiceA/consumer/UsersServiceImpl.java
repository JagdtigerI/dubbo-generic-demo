package com.dulio.demo.dubboServiceA.consumer;

import com.dulio.demo.dubboServiceA.api.UserService;
import com.dulio.demo.dubboServiceA.api.UsersService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
@Path("users")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserService userService;

    @Override
    @GET
    @Path("{ids}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUsers(@PathParam("ids") String ids) {
        List<String> uids = new ArrayList<>();
        for (String id : ids.split(",")) {
            uids.add(userService.getUser(id));
        }
        return String.join(";", uids);
    }
}