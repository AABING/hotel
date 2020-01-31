package com.face.hotel.service;

import com.face.hotel.entity.GymInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午10:06
 **/
public interface GymInfoService {

    List<GymInfo> getAllGymInfo();

    GymInfo getGymInfoById(String id);

}
