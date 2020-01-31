package com.face.hotel.service;

import com.face.hotel.entity.UserInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:03
 */
public interface UserInfoService {

    /**
     * description: 获取所有用户信息
     *
     * @return java.util.List<com.face.hotel.entity.UserInfo>
     * @author LiBingxiang
     * @date 2020/01/31 14:08:25
     */
    List<UserInfo> getAllUserInfo();

    /**
     * description: 根据用户id获取所有用户信息
     *
     * @param id 用户id
     * @return com.face.hotel.entity.UserInfo
     * @author LiBingxiang
     * @date 2020/01/31 14:24:39
     */
    UserInfo getUserInfoById(String id);
}
