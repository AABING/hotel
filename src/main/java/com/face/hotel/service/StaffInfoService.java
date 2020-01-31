package com.face.hotel.service;

import com.face.hotel.entity.StaffInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:03
 */
public interface StaffInfoService {

    /**
    *@Author: NaiPan
    *@Description: 获取所有员工信息
    *
    *@return: java.util.List<com.face.hotel.entity.StaffInfo>
    *@date: 2020/1/31
    */
    List<StaffInfo> getAllStaffInfo();

    /**
    *@Author: NaiPan
    *@Description: 根据id获取员工信息
    *@Param:
    *@return: com.face.hotel.entity.StaffInfo
    *@date: 2020/1/31
    */
    StaffInfo getStaffInfoById(String id);
}
