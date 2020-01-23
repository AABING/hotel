package com.face.hotel.service.impl;

import com.face.hotel.mapper.UserRoomMapper;
import com.face.hotel.service.UserRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:08
 */
@Service
public class UserRoomServiceImpl implements UserRoomService {

    @Resource
    UserRoomMapper userRoomMapper;
}
