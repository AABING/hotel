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

    /**
     * description: 新增用户信息
     *
     * @param userInfo 用户实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:19:36
     */
    String insertUserInfo(UserInfo userInfo) throws Exception;

    /**
     * description: 修改用户信息
     *
     * @param userInfo 用户实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 15:32:52
     */
    String updateUserInfo(UserInfo userInfo) throws Exception;

    /**
     * description: 删除用户信息
     *
     * @param id 用户id
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:23:33
     */
    String deleteUserInfo(String id) throws Exception;

    /**
     * description: 通过身份证号获取用户信息
     *
     * @param cardNumber 身份证号
     * @return com.face.hotel.entity.UserInfo
     * @author LiBingxiang
     * @date 2020/02/04 17:15:37
     */
    UserInfo getUserInfoByCardNumber(String cardNumber);

    /**
     * description: 通过人脸信息查找用户
     *
     * @param faceMessage 人脸信息
     * @return com.face.hotel.entity.UserInfo
     * @author LiBingxiang
     * @date 2020/02/04 21:21:56
     */
    UserInfo getUserInfoByFace(String faceMessage);
}