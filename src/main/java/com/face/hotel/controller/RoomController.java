package com.face.hotel.controller;

import com.face.hotel.component.FaceRecognitionComponent;
import com.face.hotel.entity.RoomInfo;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.entity.UserRoom;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.RoomInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private UserRoomController userRoomController;

    @Autowired
    FaceRecognitionComponent faceRecognitionComponent;

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

    /**
     * 房间门禁: 用户退房则员工可以开锁
     * @param faceInfo 人面信息
     * @param rId 房间ID
     * @return
     */
    @ApiOperation("房间门禁")
    @PostMapping("/entranceGuard")
    public Result<Boolean> entranceGuard(@RequestParam("faceInfo") MultipartFile faceInfo, Long rId) {
        Result<Boolean> result = new Result<>();
        result.setData(false);

        // 用户人面识别
        if (null != rId) {
            // 查询是否有用户入住
            RoomInfo roomInfo = roomInfoService.getRoomInfoById(rId.toString());
            if (null == roomInfo) {
                result.setMassage("房间号不存在！");
                result.setStatus(ResultCode.NOT_FIND);
                return result;
            }
            // 确保该用户未退房并且进入的是自己的房间
            Long uId = roomInfo.getUId();
            if (roomInfo.getStatus() != 0) {
                // 当前房间有用户使用时，则只有用户才何以使用该房间
                try {
                    Boolean aBoolean = faceRecognitionComponent.userFaceRecognition(uId, faceInfo);
                    result.setData(aBoolean);
                    if (aBoolean) {
                        result.setMassage("用户： " + uId + " 识别通过！");
                    } else {
                        result.setMassage("非法用户！");
                    }
                } catch (Exception e) {
                    result.setMassage(e.getMessage());
                    result.setStatus(ResultCode.NOT_FIND);
                } finally {
                    return result;
                }
            } else {
                // 员工开锁
                // 当该房间当前无用户使用时，才可以交于员工使用
                try {
                    Boolean aBoolean = faceRecognitionComponent.staffFaceRecognition(roomInfo.getStaffId(), faceInfo);
                    if (aBoolean) {
                        result.setData(true);
                        result.setMassage("员工：" + roomInfo.getStaffId() + " 识别通过！");
                    } else {
                        result.setMassage("员工信息不匹配！");
                    }
                } catch (Exception e) {
                    result.setMassage(e.getMessage());
                    result.setStatus(ResultCode.ERROR);
                }
                return result;
            }
        }
        result.setMassage("请传入房间ID！");
        return result;
    }
}
