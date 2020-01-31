package com.face.hotel.service.impl;

import com.face.hotel.entity.UserInfo;
import com.face.hotel.mapper.UserInfoMapper;
import com.face.hotel.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
