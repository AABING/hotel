package com.face.hotel.controller;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
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
 * @date: 2020/1/31 15:28
 * @package_name: com.face.hotel.controller
 * @project_name: hotel
 * @description: 员工信息控制
 */

@RestController
@RequestMapping("/staff")
@Slf4j
@Api(description = "员工信息")
public class StaffController {
    @Autowired
    private StaffInfoService staffInfoService;

    @ApiOperation("获取所有员工信息")
    @GetMapping("/get")
    public Result<List<StaffInfo>> getAllStaffInfo() {
        Result<List<StaffInfo>> result = new Result<>();
        try {
            List<StaffInfo> allStaffInfo = staffInfoService.getAllStaffInfo();
            result.setData(allStaffInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个员工信息")
    @GetMapping("/get/{id}")
    public Result<StaffInfo> getStaffInfoById(@PathVariable String id) {
        Result<StaffInfo> result = new Result<>();
        try {
            StaffInfo staffInfo = staffInfoService.getStaffInfoById(id);
            result.setData(staffInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
