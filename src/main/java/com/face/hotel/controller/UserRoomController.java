package com.face.hotel.controller;

import com.face.hotel.entity.UserRoom;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.UserRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: UserRoomController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/31 17:38
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user/room")
@Slf4j
@Api(description = "入住信息")
public class UserRoomController {
    @Autowired
    private UserRoomService userRoomService;

    @ApiOperation("获取所有入住信息")
    @GetMapping("/get")
    public Result<List<UserRoom>> getAllUserRoom() {
        Result<List<UserRoom>> result = new Result<>();
        try {
            List<UserRoom> allUserRoom = userRoomService.getAllUserRoomInfo();
            result.setData(allUserRoom);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个入住信息")
    @GetMapping("/get/{userId}/{roomId}")
    public Result<UserRoom> getUserRoomById(@PathVariable String userId, @PathVariable String roomId) {
        Result<UserRoom> result = new Result<>();
        try {
            UserRoom userInfo = userRoomService.getUserRoomInfoById(userId, roomId);
            result.setData(userInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增入住信息")
    @PostMapping("/insert")
    public Result<String> insertUserRoom(UserRoom userRoom) {
        Result<String> result = new Result<>();
        try {
            String s = userRoomService.insertUserRoomInfo(userRoom);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改入住信息")
    @PutMapping("/update")
    public Result<String> updateUserRoom(UserRoom userRoom) {
        Result<String> result = new Result<>();
        try {
            String s = userRoomService.updateUserRoomInfo(userRoom);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除入住信息")
    @DeleteMapping("/delete/{userId}/{roomId}")
    public Result<String> deleteUserRoom(@PathVariable String userId, @PathVariable String roomId) {
        Result<String> result = new Result<>();
        try {
            String s = userRoomService.deleteUserRoomInfo(userId, roomId);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}

