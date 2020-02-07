package com.face.hotel.service.impl;

import com.face.hotel.entity.StaffChecking;
import com.face.hotel.mapper.StaffCheckingMapper;
import com.face.hotel.service.StaffCheckingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: naipan
 * @date: 2020/2/6 17:30
 * @package_name: com.face.hotel.service.impl
 * @project_name: hotel
 * @description:
 */
@Service
public class StaffCheckingServiceImpl implements StaffCheckingService {
    @Resource
    private StaffCheckingMapper staffCheckingMapper;

    @Override
    public List<StaffChecking> getAllStaffChecking() {
        return staffCheckingMapper.selectAll();
    }

    @Override
    public List<StaffChecking> getStaffCheckingById(Long staffId) {
        return staffCheckingMapper.getStaffCheckingById(staffId);
    }

    @Override
    public String insertStaffChecking(StaffChecking staffChecking) throws Exception {
        int result = staffCheckingMapper.insert(staffChecking);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateStaffChecking(StaffChecking staffChecking) throws Exception {
        int result = staffCheckingMapper.updateByPrimaryKeySelective(staffChecking);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteStaffChecking(Long staffId) throws Exception {
        int result = staffCheckingMapper.deleteStaffCheckingById(staffId);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public StaffChecking getLastGymInfo(Long id) {
        return staffCheckingMapper.getLastGymInfo(id);
    }
}
