package com.wb.wbao.service;

import com.h3c.common.model.CommonDTO;
import com.wb.wbao.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dell on 2018/3/4.
 */
@FeignClient(value = "microservice-gateway-zuul")
public interface MamboServiceClient {

    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    List<UserDTO> queryAll();

    @RequestMapping(value = "/user/users/{id}", method = RequestMethod.GET)
    UserDTO queryById(@PathVariable(value = "id") Long id);

    @RequestMapping(value = "/user/users", method = RequestMethod.POST)
    List<UserDTO> createUser(@RequestBody UserDTO userDTO);

    @RequestMapping(value = "/user/users", method = RequestMethod.PUT)
    List<UserDTO> modifyUser(@RequestBody UserDTO userDTO);

    @RequestMapping(value = {"/{ids}"}, method = RequestMethod.DELETE)
    List<UserDTO> removeUsers(@PathVariable(value = "ids") Long[] ids);

    @RequestMapping(value = "/user/users/login", method = RequestMethod.POST)
    CommonDTO login(@RequestBody UserDTO user);



}
