package com.face.hotel.controller;

import com.face.hotel.entity.EquipmentInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.EquipmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/2/1 下午9:09
 */
@RequestMapping("/equipment")
@Slf4j
@RestController
@Api("人面识别设备控制器")
public class EquipmentController {

    @Autowired
    EquipmentInfoService equipmentInfoService;

    @ApiOperation("得到所有的设备信息")
    @GetMapping("/get")
    public Result<List<EquipmentInfo>> getAllEquipmentInfo() {
        Result<List<EquipmentInfo>> result = new Result<>();

        try {
            List<EquipmentInfo> equipmentInfos = equipmentInfoService.getAllEquipmentInfo();
            result.setData(equipmentInfos);
        } catch(Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("根据ID得到设备信息")
    @GetMapping("/get/{id}")
    public Result<EquipmentInfo> getEquipmentInfo(@PathVariable Long id) {
        Result<EquipmentInfo> result = new Result<>();

        try {
            EquipmentInfo equipment = equipmentInfoService.getEquipmentById(id);
            result.setData(equipment);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }

    @ApiOperation("插入人面识别设备信息")
    @PostMapping("/insert")
    public Result<String> insertEquipmentInfo(EquipmentInfo equipmentInfo) {
        Result<String> result = new Result<>();

        try {
            String info = equipmentInfoService.insertEquipmentInfo(equipmentInfo);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("更新人面识别设备信息")
    @PutMapping("/update")
    public Result<String> updateEquipmentInfo(EquipmentInfo equipmentInfo) {

        Result<String> result = new Result<>();

        try {
            String info = equipmentInfoService.updateEquipmentInfo(equipmentInfo);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("删除人面识别设备信息")
    @DeleteMapping("/delete")
    public Result<String> deleteEquipmentInfo(@PathVariable Long id) {
        Result<String> result = new Result<>();

        try {
            String info = equipmentInfoService.deleteEquipmentInfo(id);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }
}
