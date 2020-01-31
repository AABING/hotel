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
}
