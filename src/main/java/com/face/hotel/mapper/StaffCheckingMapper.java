package com.face.hotel.mapper;

import com.face.hotel.entity.StaffChecking;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: naipan
 * @date: 2020/2/6 17:30
 * @package_name: com.face.hotel.mapper
 * @project_name: hotel
 * @description:
 */
public interface StaffCheckingMapper extends Mapper<StaffChecking> {
    /**
     * @Author: naipan
     * @Date: 2020/2/6 17:56
     * @Class_name: StaffCheckingMapper
     * @Description: 获取当个员工所有考勤记录
     */
    List<StaffChecking> getStaffCheckingById(Long staffId);

    /**
     * @Author: naipan
     * @Date: 2020/2/6 18:13
     * @Class_name: StaffCheckingMapper
     * @Description: 删除员工的考勤记录
     */
    int deleteStaffCheckingById(Long staffId);

    /**
     * @Author: naipan
     * @Date: 2020/2/6 22:28
     * @Class_name: StaffCheckingMapper
     * @Description: 获取该员工最后一次的上班打卡记录
     */
    StaffChecking getLastGymInfo(Long id);
}
