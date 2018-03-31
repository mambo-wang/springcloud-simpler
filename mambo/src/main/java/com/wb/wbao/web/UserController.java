package com.wb.wbao.web;

import com.wb.wbao.dto.UserDTO;
import com.wb.wbao.service.MamboServiceClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by dell on 2017/7/2.
 * 控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private MamboServiceClient mamboServiceClient;

    @GetMapping(value = "/{id}")
    public UserDTO queryById(@PathVariable Long id){
        return mamboServiceClient.queryById(id);
    }

    @ApiOperation(value = "创建用户",notes = "根据用户名、密码、入学年份、用户姓名创建用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PostMapping
    public List<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return mamboServiceClient.createUser(userDTO);
    }

    @ApiOperation(value = "查询用户", notes = "查询所有用户")
    @GetMapping
    public List<UserDTO> queryAllUsers() {
        return mamboServiceClient.queryAll();
    }

    @ApiOperation(value = "修改",notes = "根据用户名、密码、入学年份、用户姓名修改用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PutMapping
    public List<UserDTO> modifyUser(@RequestBody UserDTO userDTO){
        return mamboServiceClient.modifyUser(userDTO);
    }

    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
    @ApiImplicitParam(name = "idList", value = "用户id集合", required = true, dataType = "ArrayList")
    @DeleteMapping(value = {"/{idList}"})
    public List<UserDTO> removeUsers(@PathVariable List<Long> idList){
        return Collections.emptyList();
    }
}
