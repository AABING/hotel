package com.face.hotel.controller;

import com.face.hotel.entity.BillInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.BillInfoService;
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
 * @date: 2020/1/31 16:59
 * @package_name: com.face.hotel.controller
 * @project_name: hotel
 * @description:
 */

@RestController
@RequestMapping("/bill")
@Slf4j
@Api(description = "所有账单消费信息")
public class BillController {
    @Autowired
    private BillInfoService billInfoService;

    @ApiOperation("获取所有账单信息")
    @GetMapping("/get")
    public Result<List<BillInfo>> getAllBillInfo() {
        Result<List<BillInfo>> result = new Result<>();
        try {
            List<BillInfo> allBillInfo = billInfoService.getAllBillInfo();
            result.setData(allBillInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据用户id获取其账单信息")
    @GetMapping("/get/{userId}")
    public Result<List<BillInfo>> getBillInfoByUserId(@PathVariable Long userId) {
        Result<List<BillInfo>> result = new Result<>();
        try {
            List<BillInfo> userBillInfo = billInfoService.getBillInfoByUserId(userId);
            result.setData(userBillInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
