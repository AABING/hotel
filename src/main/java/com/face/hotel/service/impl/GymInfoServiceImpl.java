package com.face.hotel.service.impl;

import com.face.hotel.entity.GymInfo;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.mapper.GymInfoMapper;
import com.face.hotel.service.GymInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:04
 */
@Service
public class GymInfoServiceImpl implements GymInfoService {

    @Resource
    GymInfoMapper gymInfoMapper;

    @Override
    public List<GymInfo> getAllGymInfo(){
        return gymInfoMapper.selectAll();
    }

    @Override
    public GymInfo getGymInfoById(String id){
        return gymInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertGymInfo(GymInfo gymInfo) throws Exception {
        int result = gymInfoMapper.insert(gymInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateGymInfo(GymInfo gymInfo) throws Exception {
        int result = gymInfoMapper.updateByPrimaryKeySelective(gymInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteGymInfo(String id) throws Exception {
        int result = gymInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }

    @Override
    public GymInfo getLastGymInfo(Long uid) {
        return gymInfoMapper.getLastGymInfo(uid);
    }
}
