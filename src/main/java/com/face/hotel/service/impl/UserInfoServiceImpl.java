package com.face.hotel.service.impl;

import com.face.hotel.mapper.UserInfoMapper;
import com.face.hotel.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:07
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
}
