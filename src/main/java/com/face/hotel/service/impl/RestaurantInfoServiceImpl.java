package com.face.hotel.service.impl;

import com.face.hotel.mapper.RestaurantInfoMapper;
import com.face.hotel.service.RestaurantInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:06
 */
@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    @Resource
    RestaurantInfoMapper restaurantInfoMapper;
}
