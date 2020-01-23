package com.face.hotel.service.impl;

import com.face.hotel.mapper.StaffInfoMapper;
import com.face.hotel.service.StaffInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
