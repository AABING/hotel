package com.face.hotel.controller;

import com.face.hotel.entity.VehicleInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.VehicleInfoService;
import com.face.hotel.component.FaceRecognitionComponent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
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
public class VehicleController {

    /**
     * 停取车时需要获取用户的人面信息。
     */
    @Autowired
    UserController userController;

    @Resource
    FaceRecognitionComponent faceRecognitionComponent;

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

    @ApiOperation("根据Id查询停车信息")
    @GetMapping("/get/{id}")
    public Result<VehicleInfo> getVehicleInfoById(@PathVariable Long id) {

        Result<VehicleInfo> result = new Result<>();

        try {
            VehicleInfo vehicleInfo = vehicleInfoService.getVehicleInfoById(id);
            result.setData(vehicleInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }

    @ApiOperation("修改停车信息")
    @PutMapping("/update")
    public Result<String> updateVehicleInfo(VehicleInfo vehicleInfo) {
        Result<String> result = new Result<>();

        try {
            String info = vehicleInfoService.updateVehicleInfo(vehicleInfo);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("插入停车信息")
    @PostMapping("/insert")
    public Result<String> insertVehicleInfo(VehicleInfo vehicleInfo) {
        Result<String> result = new Result<>();

        try {
            String info = vehicleInfoService.insertVehicleInfo(vehicleInfo);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("根据ID删除停车信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteVehicleInfo(@PathVariable Long id) {
        Result<String> result = new Result<>();

        try {
            String info = vehicleInfoService.deleteVehicleInfo(id);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("停车入库")
    @PostMapping("/vehicleIn")
    public Result<Boolean> vehicleIn(Long uid, @RequestParam("face2Info") MultipartFile face2Info) {
        Result<Boolean> result = new Result<>();
        result.setData(false);

        // ①人面识别
        Boolean faceRecognition = Boolean.FALSE;
        try {
            /*
            人面识别异常：
                1、用户不存在
                2、用户用户信息存在，但是用户未注册人面信息
                3、用于人面检测的零时文件格式不对
             */

            faceRecognition = faceRecognitionComponent.userFaceRecognition(uid, face2Info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
            return result;
        }
        // 人面匹配失败则不能通行。
        if (!faceRecognition) {
            result.setMassage("人面识别失败");
            return result;
        }

        // ②检测车位是否有车
        VehicleInfo lastVehicleIn = vehicleInfoService.getLastVehicleIn(uid);
        // 如果查询到用户最近一次停车却未取车的情况，则取车异常
        if (null != lastVehicleIn) {
            result.setMassage("该车位已停放车辆");
            return result;
        }

        // ③更新停车信息
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setUserId(uid);
        // 设置收费率
        vehicleInfo.setChargeRates(10);
        // 记录进入车库的时间
        vehicleInfo.setTimeIn(new Date(System.currentTimeMillis()));
        // TODO 记录用户车牌号
        vehicleInfo.setCarNumber("湘A232432");
        // 设置车位状态为正在使用
        vehicleInfo.setStatus("正在使用");

        // ④记录入库信息
        try {
            vehicleInfoService.insertVehicleInfo(vehicleInfo);
            //result.setMassage(userInfo.getData().toString());
            result.setData(true);
        } catch (Exception e) {
            result.setMassage(e.getMessage());
            result.setStatus(ResultCode.ERROR);
        }

        return result;
    }


    @ApiOperation("取车")
    @PutMapping("/vehicleOut")
    public Result<Boolean> vehicleOut(Long uid, @RequestParam("face2Info") MultipartFile face2Info) {
        Result<Boolean> result = new Result<>();
        result.setData(false);

        // ①人面识别
        Boolean faceRecognition = Boolean.FALSE;
        try {
            /*
            人面识别异常：
                1、用户不存在
                2、用户用户信息存在，但是用户未注册人面信息
                3、用于人面检测的零时文件格式不对
             */
            faceRecognition = faceRecognitionComponent.userFaceRecognition(uid, face2Info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
            return result;
        }
        // 人面匹配失败则不能通行。
        if (!faceRecognition) {
            result.setMassage("人面识别失败");
            return result;
        }

        // ②检测车位是否有车
        VehicleInfo lastVehicleIn = vehicleInfoService.getLastVehicleIn(uid);
        // 如果未查到用户最近一次停车却未取车的情况，则取车异常
        if (null == lastVehicleIn) {
            result.setMassage("该车位暂时未停放车辆");
            return result;
        }


        // ③更新取车信息
        // 设置车辆离开时间
        lastVehicleIn.setTimeOut(new Date());
        // 设置当前车位状态
        lastVehicleIn.setStatus("空闲");

        try {
            // ④更新数据库
            vehicleInfoService.updateVehicleInfo(lastVehicleIn);
            result.setData(true);
        } catch (Exception e) {
            result.setMassage(e.getMessage());
            result.setStatus(ResultCode.ERROR);
        }

        return result;
    }

}
