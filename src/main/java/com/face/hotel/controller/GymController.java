package com.face.hotel.controller;

import com.face.hotel.entity.GymInfo;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.GymInfoService;
import com.face.hotel.service.StaffInfoService;
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
 * @author: naipan
 * @date: 2020/1/31 18:35
 * @package_name: com.face.hotel.controller
 * @project_name: hotel
 * @description:
 */
@RestController
@RequestMapping("/gym")
@Slf4j
@Api(description = "健身房消费信息")
public class GymController {
    @Autowired
    private GymInfoService gymInfoService;

    @ApiOperation("获取所有健身消费信息")
    @GetMapping("/get")
    public Result<List<GymInfo>> getAllGymInfo() {
        Result<List<GymInfo>> result = new Result<>();
        try {
            List<GymInfo> allGymInfo = gymInfoService.getAllGymInfo();
            result.setData(allGymInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个成员健身消费信息")
    @GetMapping("/get/{id}")
    public Result<GymInfo> getGymInfoById(@PathVariable String id) {
        Result<GymInfo> result = new Result<>();
        try {
            GymInfo gymInfo = gymInfoService.getGymInfoById(id);
            result.setData(gymInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

}
