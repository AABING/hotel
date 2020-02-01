package com.face.hotel.service.impl;

import com.face.hotel.entity.StaffInfo;
import com.face.hotel.mapper.StaffInfoMapper;
import com.face.hotel.service.StaffInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:07
 */
@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Resource
    StaffInfoMapper staffInfoMapper;

    @Override
    public List<StaffInfo> getAllStaffInfo(){
        return staffInfoMapper.selectAll();
    }

    @Override
    public StaffInfo getStaffInfoById(String id){
        return staffInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertStaffInfo(StaffInfo staffInfo) throws Exception {
        int result = staffInfoMapper.insert(staffInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateStaffInfo(StaffInfo staffInfo) throws Exception {
        int result = staffInfoMapper.updateByPrimaryKeySelective(staffInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteStaffInfo(String id) throws Exception {
        int result = staffInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }
}
