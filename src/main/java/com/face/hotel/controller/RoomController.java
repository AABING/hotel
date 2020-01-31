package com.face.hotel.controller;

import com.face.hotel.entity.RoomInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.RoomInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: RoomController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/31 16:57
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/room")
@Slf4j
@Api(description = "房间信息")
public class RoomController {
    @Autowired
    private RoomInfoService roomInfoService;

    @ApiOperation("获取所有房间信息")
    @GetMapping("/get")
    public Result<List<RoomInfo>> getAllRoomInfo() {
        Result<List<RoomInfo>> result = new Result<>();
        try {
            List<RoomInfo> allRoomInfo = roomInfoService.getAllRoomInfo();
            result.setData(allRoomInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个房间信息")
    @GetMapping("/get/{id}")
    public Result<RoomInfo> getRoomInfoById(@PathVariable String id) {
        Result<RoomInfo> result = new Result<>();
        try {
            RoomInfo roomInfo = roomInfoService.getRoomInfoById(id);
            result.setData(roomInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增房间信息")
    @PostMapping("/insert")
    public Result<String> insertRoomInfo(RoomInfo roomInfo) {
        Result<String> result = new Result<>();
        try {
            String s = roomInfoService.insertRoomInfo(roomInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改房间信息")
    @PutMapping("/update")
    public Result<String> updateRoomInfo(RoomInfo roomInfo) {
        Result<String> result = new Result<>();
        try {
            String s = roomInfoService.updateRoomInfo(roomInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除房间信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteRoomInfo(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = roomInfoService.deleteRoomInfo(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }
}
