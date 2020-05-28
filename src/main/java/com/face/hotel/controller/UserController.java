package com.face.hotel.controller;

import com.face.hotel.entity.BillInfo;
import com.face.hotel.entity.UserInfo;
import com.face.hotel.entity.UserRoom;
import com.face.hotel.entity.VehicleInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.BillInfoService;
import com.face.hotel.service.UserInfoService;
import com.face.hotel.service.UserRoomService;
import com.face.hotel.service.VehicleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Description: UserController
 *
 * @author LiBingxiang
 * @version 1.0
 * @date 2020/01/31 13:53
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(description = "用户信息")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserRoomService userRoomService;
    @Autowired
    private BillInfoService billInfoService;
    @Autowired
    private VehicleInfoService vehicleInfoService;

    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ApiOperation("获取所有用户信息")
    @GetMapping("/get")
    public Result<List<UserInfo>> getAllUserInfo() {
        Result<List<UserInfo>> result = new Result<>();
        try {
            List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();
            result.setData(allUserInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("根据id获取单个用户信息")
    @GetMapping("/get/{id}")
    public Result<UserInfo> getUserInfoById(@PathVariable String id) {
        Result<UserInfo> result = new Result<>();
        try {
            UserInfo userInfo = userInfoService.getUserInfoById(id);
            result.setData(userInfo);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("新增用户信息")
    @PostMapping("/insert")
    public Result<String> insertUserInfo(UserInfo userInfo) {
        Result<String> result = new Result<>();
        try {
            String s = userInfoService.insertUserInfo(userInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    public Result<String> updateUserInfo(UserInfo userInfo) {
        Result<String> result = new Result<>();
        try {
            String s = userInfoService.updateUserInfo(userInfo);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteUserInfo(@PathVariable String id) {
        Result<String> result = new Result<>();
        try {
            String s = userInfoService.deleteUserInfo(id);
            result.setData(s);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }
        return result;
    }

    @ApiOperation("用户预订房间")
    @PostMapping("/book/{userId}/{roomId}")
    public Result<String> bookRoom(UserRoom userRoom) {
        Result<String> result = new Result<>();
        userRoom.setScheduledTime(s.format(new Date()));
        try {
            userRoomService.insertUserRoomInfo(userRoom);
        } catch (Exception e) {
            result.setData("预订失败");
        }
        return result;
    }

    @ApiOperation("用户入住")
    @PutMapping("/userCheckIn")
    @PostMapping("/checkIn")
    public Result<String> userCheckIn(String faceMessage) {
        Result<String> result = new Result<>();
        // 1、判断人脸与身份证是否为同一人
        boolean isRealFace = true;
        if (isRealFace) {
            // 2、如果是同一个人，则获取身份证号码
            // 此处身份证号应通过人证识别提取
            String cardNumber = "123456";
            // 3、通过身份证号获取用户信息
            UserInfo userInfo = userInfoService.getUserInfoByCardNumber(cardNumber);
            if (userInfo == null || "".equals(userInfo)) {
                result.setData("查无此人");
            } else {
                boolean bool1 = userInfo.getName().equals("jack");
                boolean bool2 = userInfo.getGender().equals("1");
                // 一系列信息比较判断
                if (bool1 && bool2) {
                    UserRoom userRoom = new UserRoom();
                    userRoom.setUserId(userInfo.getId());
                    userRoom.setCheckInTime(s.format(new Date()));
                    userRoom.setEffect(1);
                    userInfo.setStayNumber(userInfo.getStayNumber() + 1);
                    // 储存人脸信息，应从人证识别信息中获取
                    userInfo.setFace("jack");
                    try {
                        userRoomService.updateUserRoomInfo(userRoom);
                        userInfoService.updateUserInfo(userInfo);
                    } catch (Exception e) {
                        result.setData("开通房间失败，请重试或人工办理");
                        return result;
                    }
                    result.setData("验证通过，欢迎入住");


                } else {
                    result.setData("信息不符，请重试或人工办理");
                }
            }
        } else {
            result.setData("人证不符，请重试或人工办理");
        }
        return result;
    }

    @ApiOperation("用户退房")
    @PostMapping("/checkOut")
    public Result<String> userCheckOut(String faceMessage) {
        Result<String> result = new Result<>();
        // 1、提取人脸识别信息，根据人脸信息查找用户
        UserInfo userInfo = userInfoService.getUserInfoByFace(faceMessage);
        if (userInfo == null || "".equals(userInfo)) {
            result.setData("人脸认证失败，请重试或人工办理");
        } else {
            Long userId = userInfo.getId();

            // 2、将停车费计入消费流水表
            VehicleInfo vehicleInfo = vehicleInfoService.getVehicleInfo(userId);
            if (vehicleInfo.getStatus() == 1) {
                long timeIn;
                try {
                    timeIn = s.parse(vehicleInfo.getIn()).getTime();
                } catch (Exception e) {
                    result.setData("系统出错，请重试！");
                    return result;
                }
                long hour = (System.currentTimeMillis() - timeIn) / 3600000;
                double cost = Double.parseDouble(vehicleInfo.getChargeRates()) * hour;

                // 3、存入消费流水表
                BillInfo billInfo = new BillInfo();
                billInfo.setCost(cost);
                billInfo.setName("停车消费");
                billInfo.setDescription("停车消费");
                billInfo.setFullName("停车消费");
                billInfo.setTime(s.format(new Date()));
                billInfo.setTransactionId("123456");
                billInfo.setShopId("123456");
                billInfo.setFlag(0);
                billInfo.setUserId(userId);
                try {
                    billInfoService.insertBillInfo(billInfo);
                } catch (Exception e) {
                    result.setData("系统出错，请重试！");
                    return result;
                }
                // 4、待消费金额存入用户使用表中,将消费流水表flag设为1
                userInfo.setDebt(userInfo.getDebt() + cost);
                billInfo.setFlag(1);
                try {
                    userInfoService.updateUserInfo(userInfo);
                    billInfoService.updateBillInfo(billInfo);
                } catch (Exception e) {
                    result.setData("系统出错，请重试！");
                    return result;
                }
            }

            // 3、查询是否有未计入用户表的消费
            Double debt = billInfoService.getBillDebt(userId);
            if (debt != 0) {
                userInfo.setDebt(userInfo.getDebt() + debt);
                try {
                    userInfoService.updateUserInfo(userInfo);
                } catch (Exception e) {
                    result.setData("系统出错，请重试！");
                    return result;
                }
            }

            // 4、付款。结账成功后将用户表debt设置为0
            userInfo.setDebt(0.00);
            try {
                userInfoService.updateUserInfo(userInfo);
            } catch (Exception e) {
                result.setData("系统出错，请重试！");
                return result;
            }

            // 5、删除入住信息表信息
            try {
                userRoomService.deleteUserRoomInfo(userId);
            } catch (Exception e) {
                result.setData("系统出错，请重试！");
                return result;
            }
            result.setData("退房成功，欢迎下次再来");
        }
        return result;
    }
}