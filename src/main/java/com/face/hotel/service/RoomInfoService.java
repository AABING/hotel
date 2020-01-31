package com.face.hotel.service;

import com.face.hotel.entity.RoomInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:02
 */
public interface RoomInfoService {

    /**
     * description: 获取所有房间信息
     *
     * @return java.util.List<com.face.hotel.entity.RoomInfo>
     * @author LiBingxiang
     * @date 2020/01/31 17:00:21
     */
    List<RoomInfo> getAllRoomInfo();

    /**
     * description: 根据id获取房间信息
     *
     * @param id 房间id
     * @return com.face.hotel.entity.RoomInfo
     * @author LiBingxiang
     * @date 2020/01/31 17:03:02
     */
    RoomInfo getRoomInfoById(String id);

    /**
     * description: 新增房间信息
     *
     * @param roomInfo 房间实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 17:04:29
     */
    String insertRoomInfo(RoomInfo roomInfo) throws Exception;

    /**
     * description: 修改房间信息
     *
     * @param roomInfo 房间实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 17:05:51
     */
    String updateRoomInfo(RoomInfo roomInfo) throws Exception;

    /**
     * description: 删除房间信息
     *
     * @param id 房间id
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 17:07:29
     */
    String deleteRoomInfo(String id) throws Exception;
}
