package com.face.hotel.service;

import com.face.hotel.entity.StaffChecking;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: naipan
 * @date: 2020/2/6 17:30
 * @package_name: com.face.hotel.service
 * @project_name: hotel
 * @description:
 */
@Service
public interface StaffCheckingService {
    /**
    *@Author: NaiPan
    *@Description: 获取所有员工的所有考勤记录
    *@return: java.util.List<com.face.hotel.entity.StaffChecking>
    *@date: 2020/2/6
    */
    List<StaffChecking> getAllStaffChecking();

    /**
    *@Author: NaiPan
    *@Description: 通过员工id查询所有考勤记录
    *@Param: staffId
    *@return:  java.util.List<com.face.hotel.entity.StaffChecking>
    *@date: 2020/2/6
    */
    List<StaffChecking> getStaffCheckingById(Long staffId);

    /**
    *@Author: NaiPan
    *@Description: 新增员工考勤记录
    *@Param: com.face.hotel.entity.StaffChecking
    *@return: String
    *@date: 2020/2/6
    */
    String insertStaffChecking(StaffChecking staffChecking) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 更新一条员工考勤记录
    *@Param: com.face.hotel.entity.StaffChecking
    *@return: String
    *@date: 2020/2/6
    */
    String updateStaffChecking(StaffChecking staffChecking) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 删除一名员工的所有考勤记录
    *@Param: staffId
    *@return: String
    *@date: 2020/2/6
    */
    String deleteStaffChecking(Long staffId) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 获取该员工最近一次上班打卡记录，没有下班打卡记录
    *@Param: id
    *@return: com.face.hotel.entity.StaffChecking
    *@date: 2020/2/6
    */
    StaffChecking getLastGymInfo(Long id);
}
