package com.face.hotel.controller;

import com.face.hotel.entity.RestaurantInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.RestaurantInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: RestaurantController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/02/01 13:39
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/restaurant")
@Slf4j
@Api(description = "餐厅订单信息")
public class RestaurantController {
    @Autowired
    private RestaurantInfoService restaurantService;

    @ApiOperation("获取所有餐厅订单信息")
    @GetMapping("/get")
    public Result<List<RestaurantInfo>> getAllRestaurantInfo() {
        Result<List<RestaurantInfo>> result = new Result<>();
        try {
            List<RestaurantInfo> allRestaurantInfo = restaurantService.getAllRestaurantInfo();
            result.setData(allRestaurantInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个餐厅订单信息")
    @GetMapping("/get/{id}")
    public Result<RestaurantInfo> getRestaurantInfoById(@PathVariable String id) {
        Result<RestaurantInfo> result = new Result<>();
        try {
            RestaurantInfo restaurant = restaurantService.getRestaurantInfoById(id);
            result.setData(restaurant);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个餐厅订单信息")
    @GetMapping("/get/user/{userId}")
    public Result<List<RestaurantInfo>> getRestaurantInfoByUserId(@PathVariable String userId) {
        Result<List<RestaurantInfo>> result = new Result<>();
        try {
            List<RestaurantInfo> restaurant = restaurantService.getRestaurantInfoByUserId(userId);
            result.setData(restaurant);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增餐厅订单信息")
    @PostMapping("/insert")
    public Result<String> insertRestaurantInfo(RestaurantInfo restaurant) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.insertRestaurantInfo(restaurant);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改餐厅订单信息")
    @PutMapping("/update")
    public Result<String> updateRestaurantInfo(RestaurantInfo restaurant) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.updateRestaurantInfo(restaurant);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除餐厅订单信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteRestaurantInfo(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.deleteRestaurantInfo(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
