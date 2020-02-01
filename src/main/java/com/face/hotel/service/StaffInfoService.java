package com.face.hotel.service;

import com.face.hotel.entity.RoomInfo;
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

    /**
    *@Author: NaiPan
    *@Description: 插入员工信息
    *@Param: com.face.hotel.entity.StaffInfo
    *@return: String
    *@date: 2020/2/1
    */
    String insertStaffInfo(StaffInfo staffInfo) throws Exception;

   /**
   *@Author: NaiPan
   *@Description: 更新员工信息
   *@Param: com.face.hotel.entity.StaffInfo
   *@return: String
   *@date: 2020/2/1
   */
    String updateStaffInfo(StaffInfo staffInfo) throws Exception;

   /**
   *@Author: NaiPan
   *@Description: 删除员工信息
   *@Param: com.face.hotel.entity.StaffInfo
   *@return: String
   *@date: 2020/2/1
   */
    String deleteStaffInfo(String id) throws Exception;

}
