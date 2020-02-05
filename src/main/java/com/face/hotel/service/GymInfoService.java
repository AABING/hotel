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

    /**
    *@Author: NaiPan
    *@Description: 获取所有健身房消费记录
    *@return: java.util.List<com.face.hotel.entity.GymInfo>
    *@date: 2020/2/1
    */
    List<GymInfo> getAllGymInfo();

    /**
    *@Author: NaiPan
    *@Description: 通过id获取健身房消费信息
    *@Param: id
    *@return: com.face.hotel.entity.GymInfo
    *@date: 2020/2/1
    */
    GymInfo getGymInfoById(String id);

    /**
    *@Author: NaiPan
    *@Description: 插入健身房消费记录
    *@Param: com.face.hotel.entity.GymInfo
    *@return: String
    *@date: 2020/2/1
    */
    String insertGymInfo(GymInfo gymInfo) throws Exception;

   /**
   *@Author: NaiPan
   *@Description: 更新健身房消费记录
   *@Param: com.face.hotel.entity.GymInfo
   *@return: String
   *@date: 2020/2/1
   */
    String updateGymInfo(GymInfo gymInfo) throws Exception;

   /**
   *@Author: NaiPan
   *@Description: 删除健身房消费记录
   *@Param: id
   *@return: String
   *@date: 2020/2/1
   */
    String deleteGymInfo(String id) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 获取用户最后一次在健身房消费的记录
    *@Param: uid
    *@return: com.face.hotel.entity.GymInfo
    *@date: 2020/2/4
    */
    GymInfo getLastGymInfo(Long uid) throws Exception;
}
