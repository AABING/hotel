package com.face.hotel.controller;


import com.face.hotel.component.FaceRecognitionComponent;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.StaffInfoService;
import com.face.hotel.utils.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @Resource
    private FaceRecognitionComponent faceRecognitionComponent;

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
    @ApiOperation("新增员工信息")
    @PostMapping("/insert")
    public Result<String> insertStaffInfo(StaffInfo staffInfo) {
        Result<String> result = new Result<>();
        try {
            String s = staffInfoService.insertStaffInfo(staffInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改员工信息")
    @PutMapping("/update")
    public Result<String> updateStaffInfo(StaffInfo staffInfo) {
        Result<String> result = new Result<>();
        try {
            String s = staffInfoService.updateStaffInfo(staffInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除员工信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteStaffInfo(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = staffInfoService.deleteStaffInfo(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("员工人面识别")
    @PostMapping("/faceRecognition")
    public Result<StaffInfo> staffFaceRecognition(@RequestParam("faceInfo")MultipartFile faceInfo) {
        Result<StaffInfo> result = new Result<>();
        result.setMassage("人面识别未通过！");
        
        StaffInfo staff = null;
        try {
            staff = faceRecognitionComponent.staffFaceRecognition(faceInfo);
        } catch (Exception e) {
            result.setMassage(e.getMessage());
            result.setStatus(ResultCode.NOT_FIND);
        }
        if (null != staff) {
            result.setMassage("人面识别通过！");
        }
        result.setData(staff);

        return result;
    }
}
