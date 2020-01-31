package com.face.hotel.controller;

import com.face.hotel.entity.VehicleInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.VehicleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description 停车记录信息表
 * @Date 2020/1/31 下午11:16
 */
@RestController
@RequestMapping("/vehicle")
@Slf4j
@Api("停车记录信息表")
public class VehicleInfoController {

    @Autowired
    VehicleInfoService vehicleInfoService;

    @ApiOperation("得到所有的停车信息")
    @GetMapping("/get")
    public Result<List<VehicleInfo>> getALlVehicleInfo() {
        Result<List<VehicleInfo>> result = new Result<>();
        try {
            List<VehicleInfo> vehicleInfos = vehicleInfoService.getAllVehicleInfo();
            result.setData(vehicleInfos);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }
}
