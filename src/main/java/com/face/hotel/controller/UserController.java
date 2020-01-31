package com.face.hotel.controller;

import com.face.hotel.entity.UserInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: UserController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/31 13:53
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(description = "用户信息")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取所有用户信息")
    @GetMapping("/get")
    public Result<List<UserInfo>> getAllUserInfo() {
        Result<List<UserInfo>> result = new Result<>();
        try {
            List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();
            result.setData(allUserInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个用户信息")
    @GetMapping("/get/{id}")
    public Result<UserInfo> getUserInfoById(@PathVariable String id) {
        Result<UserInfo> result = new Result<>();
        try {
            UserInfo userInfo = userInfoService.getUserInfoById(id);
            result.setData(userInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
