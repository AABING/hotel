package com.face.hotel.controller;

import com.face.hotel.entity.StaffChecking;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.StaffCheckingService;
import com.face.hotel.service.StaffInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: naipan
 * @date: 2020/2/6 17:27
 * @package_name: com.face.hotel.controller
 * @project_name: hotel
 * @description:
 */

@RestController
@RequestMapping("/staffChecking")
@Slf4j
@Api(description = "员工考勤记录")
public class StaffCheckingController {

    @Autowired
    private StaffCheckingService staffCheckingService;
    @Autowired
    private StaffInfoService staffInfoService;

    @ApiOperation("获取所有员工考勤记录信息")
    @GetMapping("/get")
    public Result<List<StaffChecking>> getAllStaffChecking() {
        Result<List<StaffChecking>> result = new Result<>();
        try {
            List<StaffChecking> allStaffChecking = staffCheckingService.getAllStaffChecking();
            result.setData(allStaffChecking);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据staff_id获取单个员工所有考勤信息")
    @GetMapping("/get/{staffId}")
    public Result< List<StaffChecking>> getStaffCheckingById(@PathVariable Long staffId) {
        Result< List<StaffChecking>> result = new Result<>();
        try {
            List<StaffChecking> staffChecking = staffCheckingService.getStaffCheckingById(staffId);
            result.setData(staffChecking);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增员工考勤信息")
    @PostMapping("/insert")
    public Result<String> insertStaffChecking(StaffChecking staffChecking) {
        Result<String> result = new Result<>();
        try {
            String s = staffCheckingService.insertStaffChecking(staffChecking);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改员工考勤信息")
    @PutMapping("/update")
    public Result<String> updateStaffChecking(StaffChecking staffChecking) {
        Result<String> result = new Result<>();
        try {
            String s = staffCheckingService.updateStaffChecking(staffChecking);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除某个员工考勤记录")
    @DeleteMapping("/delete/{staffId}")
    public Result<String> deleteStaffChecking(@PathVariable Long staffId) {
        Result<String> result = new Result<>();
        try {
            String s = staffCheckingService.deleteStaffChecking(staffId);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("员工考勤打卡记录")
    @PostMapping("/checking")
    public Result<Boolean> staffCheckingDocument(Long id) throws Exception {
        Result<Boolean> result = new Result<>();

        /*
            打卡人面识别(代码)
        */

        //得到人面信息
        StaffInfo staffInfo = staffInfoService.getStaffInfoById(id.toString());

        //String face = staffInfo.getData().getFace();

        //人面识别判别（假设人脸识别成功）;
        Boolean faceRecognition = Boolean.TRUE;

        //人面识别失败
        if (!faceRecognition) {
            result.setData(false);
            result.setMassage("人面识别失败");
            return result;
        }

        //人面识别成功

        //规范时间格式
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        //获取当前时间
        Date date = new Date();

        StaffChecking lastStaffChecking = staffCheckingService.getLastGymInfo(id);

        /*
            判断是上班打卡
         */

        //该员工规定上班时间前20分钟
        Calendar rule0 = Calendar.getInstance();
        rule0.setTime(format.parse(format.format(staffInfo.getWorkBegin())));
        rule0.add(Calendar.MINUTE, -20);

        //该员工规定上班时间后5五分钟
        Calendar rule1 = Calendar.getInstance();
        rule1.setTime(format.parse(format.format(staffInfo.getWorkBegin())));
        rule1.add(Calendar.MINUTE, 5);

        //该员工规定上班时间后半个小时
        Calendar rule2 = Calendar.getInstance();
        rule2.setTime(format.parse(format.format(staffInfo.getWorkBegin())));
        rule2.add(Calendar.MINUTE, 30);

        //可打卡时间：（规定时间-20）————（规定时间+30）,其他时间打卡无效
        if (format.parse(format.format(date)).after(rule0.getTime()) && format.parse(format.format(date)).before(rule2.getTime())) {

            StaffChecking staffChecking = new StaffChecking();

            /*
               前一次出现没下班打卡视为旷工
             */
            if(null != lastStaffChecking){ staffChecking.setResult(3); }

            staffChecking.setMarkBegin(date);
            staffChecking.setName(staffInfo.getName());
            staffChecking.setStaffId(id);

            //（规定时间+5）————（规定时间+30）表示迟到
            if (format.parse(format.format(date)).after(rule1.getTime()) && format.parse(format.format(date)).before(rule2.getTime())) {
                staffChecking.setResult(2);
            }

            try {
                staffCheckingService.insertStaffChecking(staffChecking);
                result.setData(Boolean.TRUE);
            } catch (Exception e) {
                result.setStatus(ResultCode.ERROR);
                result.setMassage(e.getMessage());
            }
            return result;
        }

        /*
            判断是下班打卡
         */
        //该员工规定下班时间前30分钟
        Calendar rule3 = Calendar.getInstance();
        rule3.setTime(format.parse(format.format(staffInfo.getWorkEnd())));
        rule3.add(Calendar.MINUTE, -30);

        //该员工规定下班时间后30分钟
        Calendar rule4 = Calendar.getInstance();
        rule4.setTime(format.parse(format.format(staffInfo.getWorkEnd())));
        rule4.add(Calendar.MINUTE, 30);

        //下班打卡时间：（规定时间-30）————（规定时间+30），其他时间无效
        if (format.parse(format.format(date)).after(rule3.getTime()) && format.parse(format.format(date)).before(rule4.getTime())) {

            //出现没有上班打卡而直接进行下班打卡的异常
            Long temp = (date.getTime()-lastStaffChecking.getMarkBegin().getTime())/(1000*60*60);
            if(null == lastStaffChecking || temp > 24 ){
                lastStaffChecking.setResult(3);
                staffCheckingService.updateStaffChecking(lastStaffChecking);
                result.setData(false);
                result.setMassage("今日无上班打卡记录，下班打卡失败");
                return result;
            }

            lastStaffChecking.setMarkEnd(date);

            //考勤次数记录
            staffInfo.setChecking(staffInfo.getChecking() + 1);

            //迟到次数记录
            if (lastStaffChecking.getResult() == 2) {
                staffInfo.setLate(staffInfo.getLate() + 1);
            }

            try {
                staffCheckingService.updateStaffChecking(lastStaffChecking);
                staffInfoService.updateStaffInfo(staffInfo);
                result.setData(Boolean.TRUE);
            } catch (Exception e) {
                result.setStatus(ResultCode.ERROR);
                result.setMassage(e.getMessage());
            }
            return result;
        }

        /*
            不在打卡时间
         */
        result.setData(false);
        result.setMassage("当前时间您无法打卡");
        return result;
    }
}
