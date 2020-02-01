package com.face.hotel.controller;

import com.face.hotel.entity.RestaurantDetails;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.RestaurantDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: RestaurantDetailsController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/02/01 14:42
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/restaurantDetails")
@Slf4j
@Api(description = "餐厅订单各个商品购买详情")
public class RestaurantDetailsController {
    @Autowired
    private RestaurantDetailsService restaurantService;

    @ApiOperation("获取所有餐厅订单详情信息")
    @GetMapping("/get")
    public Result<List<RestaurantDetails>> getAllRestaurantDetails() {
        Result<List<RestaurantDetails>> result = new Result<>();
        try {
            List<RestaurantDetails> allRestaurantDetails = restaurantService.getAllRestaurantDetails();
            result.setData(allRestaurantDetails);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个餐厅订单详情信息")
    @GetMapping("/get/{id}")
    public Result<RestaurantDetails> getRestaurantDetailsById(@PathVariable String id) {
        Result<RestaurantDetails> result = new Result<>();
        try {
            RestaurantDetails restaurant = restaurantService.getRestaurantDetailsById(id);
            result.setData(restaurant);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个餐厅订单详情信息")
    @GetMapping("/get/info/{infoId}")
    public Result<List<RestaurantDetails>> getRestaurantDetailsByUserId(@PathVariable String infoId) {
        Result<List<RestaurantDetails>> result = new Result<>();
        try {
            List<RestaurantDetails> restaurant = restaurantService.getRestaurantDetailsByUserId(infoId);
            result.setData(restaurant);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增餐厅订单详情信息")
    @PostMapping("/insert")
    public Result<String> insertRestaurantDetails(RestaurantDetails restaurant) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.insertRestaurantDetails(restaurant);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改餐厅订单详情信息")
    @PutMapping("/update")
    public Result<String> updateRestaurantDetails(RestaurantDetails restaurant) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.updateRestaurantDetails(restaurant);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除餐厅订单详情信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteRestaurantDetails(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = restaurantService.deleteRestaurantDetails(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
