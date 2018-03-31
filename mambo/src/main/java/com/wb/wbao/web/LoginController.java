package com.wb.wbao.web;

import com.h3c.common.model.CommonDTO;
import com.wb.wbao.dto.UserDTO;
import com.wb.wbao.service.MamboServiceClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class LoginController {


    @Resource
    private MamboServiceClient mamboServiceClient;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonDTO login(@RequestBody UserDTO user) {
        return mamboServiceClient.login(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonDTO loginGet(@RequestParam(name = "loginname") String loginName, @RequestParam(name = "password") String password) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginName(loginName);
        userDTO.setPassword(password);
        return mamboServiceClient.login(userDTO);
    }
}
