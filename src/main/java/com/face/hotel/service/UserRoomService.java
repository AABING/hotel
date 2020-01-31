package com.face.hotel.service;

import com.face.hotel.entity.UserRoom;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:03
 */
public interface UserRoomService {

    /**
     * description: 获取所有入住信息
     *
     * @return java.util.List<com.face.hotel.entity.UserRoomInfo>
     * @author LiBingxiang
     * @date 2020/01/31 14:08:25
     */
    List<UserRoom> getAllUserRoomInfo();

    /**
     * description: 根据id获取所有入住信息
     *
     * @param userId 用户id
     * @param roomId 房间id
     * @return com.face.hotel.entity.UserRoom
     * @author LiBingxiang
     * @date 2020/01/31 18:14:54
     */
    UserRoom getUserRoomInfoById(String userId, String roomId);

    /**
     * description: 新增用户信息
     *
     * @param userRoom 入住信息实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:19:36
     */
    String insertUserRoomInfo(UserRoom userRoom) throws Exception;

    /**
     * description: 修改用户信息
     *
     * @param userRoom 入住信息实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 15:32:52
     */
    String updateUserRoomInfo(UserRoom userRoom) throws Exception;

    /**
     * description: 删除入住信息
     *
     * @param userId 用户id
     * @param roomId 房间id
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:23:33
     */
    String deleteUserRoomInfo(String userId, String roomId) throws Exception;
}
