package com.face.hotel.service;

import com.face.hotel.entity.RestaurantInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:02
 */
public interface RestaurantInfoService {

    /**
     * description: 获取所有餐厅订单信息
     *
     * @return java.util.List<com.face.hotel.entity.RestaurantInfo>
     * @author LiBingxiang
     * @date 2020/01/31 14:08:25
     */
    List<RestaurantInfo> getAllRestaurantInfo();

    /**
     * description: 根据餐厅订单id获取所有餐厅订单信息
     *
     * @param id 餐厅订单id
     * @return com.face.hotel.entity.RestaurantInfo
     * @author LiBingxiang
     * @date 2020/01/31 14:24:39
     */
    RestaurantInfo getRestaurantInfoById(String id);

    /**
     * description: 新增餐厅订单信息
     *
     * @param userInfo 餐厅订单实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:19:36
     */
    String insertRestaurantInfo(RestaurantInfo userInfo) throws Exception;

    /**
     * description: 修改餐厅订单信息
     *
     * @param userInfo 餐厅订单实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 15:32:52
     */
    String updateRestaurantInfo(RestaurantInfo userInfo) throws Exception;

    /**
     * description: 删除餐厅订单信息
     *
     * @param id 餐厅订单id
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:23:33
     */
    String deleteRestaurantInfo(String id) throws Exception;

    /**
     * description: 根据用户id查询用户的餐厅消费记录
     *
     * @param userId 用户id
     * @return java.util.List<com.face.hotel.entity.RestaurantInfo>
     * @author LiBingxiang
     * @date 2020/02/01 14:25:41
     */
    List<RestaurantInfo> getRestaurantInfoByUserId(String userId);

}
