package com.face.hotel.controller;

import com.face.hotel.entity.GymInfo;

import com.face.hotel.entity.UserInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.GymInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    /**
     * 人面识别获取用户信息
     */
    @Autowired
    private UserController userController;

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

    @ApiOperation("新增健身房消费信息")
    @PostMapping("/insert")
    public Result<String> insertGymInfo(GymInfo gymInfo) {
        Result<String> result = new Result<>();
        try {
            String s = gymInfoService.insertGymInfo(gymInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改健身房消费信息")
    @PutMapping("/update")
    public Result<String> updateGymInfo(GymInfo gymInfo) {
        Result<String> result = new Result<>();
        try {
            String s = gymInfoService.updateGymInfo(gymInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除健身房消费信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteGymInfo(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = gymInfoService.deleteGymInfo(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("客户进入健身")
    @PostMapping("/gymIn")
    public Result<Boolean> gymIn(Long uid) throws Exception {
        Result<Boolean> result = new Result<>();

        /*
            进入人面识别
         */

        //得到人面信息
        Result<UserInfo> userInfo = userController.getUserInfoById(uid.toString());
        String face = userInfo.getData().getFace();

        //人面识别判别（假设人脸识别成功）
        Boolean faceRecognition = Boolean.TRUE;

        //人面识别失败
        if(!faceRecognition){
            result.setData(false);
            result.setMassage("人面识别失败，无法进入");
            return result;
        }

        /*
        检测是否出现上次消费离开没有记录而报进入异常
         */
        GymInfo lastGymInfo = gymInfoService.getLastGymInfo(uid);
        if(null != lastGymInfo){
            result.setData(false);
            result.setMassage("该用户消费出现异常");
            return result;
        }
        //记录用户消费健身房记录
        GymInfo gymInfo = new GymInfo();

        //记录该用户id
        gymInfo.setUserId(uid);
        //登记当前用户消费率
        gymInfo.setChargeRates(10.00);
        //记录用户进入的当前时间
        gymInfo.setInTime(new Date(System.currentTimeMillis()));

        try {
            gymInfoService.insertGymInfo(gymInfo);
            result.setData(true);
        }catch (Exception e){
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("客户离开健身房")
    @PostMapping("/gymOut")
    public Result<Boolean> gymOut(Long uid) throws Exception {
        Result<Boolean> result = new Result<>();

        /*
            离开人面识别
         */

        //得到人面信息
        Result<UserInfo> userInfo = userController.getUserInfoById(uid.toString());
        String face = userInfo.getData().getFace();

        //人面识别判别（假设人脸识别成功）
        Boolean faceRecognition = Boolean.TRUE;

        //人面识别失败
        if(!faceRecognition){
            result.setData(false);
            result.setMassage("人面识别失败，无法离开");
            return result;
        }

         /*
        检测是否出现没有进入的记录导致离开异常
         */
        GymInfo lastGymInfo = gymInfoService.getLastGymInfo(uid);
        if(null == lastGymInfo){
            result.setData(false);
            result.setMassage("该用户消费出现异常");
            return result;
        }


        //更新用户消费健身房记录

        //记录用户离开的当前时间
        lastGymInfo.setOutTime(new Date(System.currentTimeMillis()));
        //记录消费金额，消费为（离开时间-进入时间）*消费率（暂时以直接数据代替）
        lastGymInfo.setCost(20.00);
        try {
            gymInfoService.insertGymInfo(lastGymInfo);
            result.setData(true);
        }catch (Exception e){
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }


}
