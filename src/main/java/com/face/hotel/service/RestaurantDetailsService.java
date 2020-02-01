package com.face.hotel.service;

import com.face.hotel.entity.RestaurantDetails;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:01
 */
public interface RestaurantDetailsService {

    /**
     * description: 获取所有餐厅订单各个商品购买详情
     *
     * @return java.util.List<com.face.hotel.entity.RestaurantDetails>
     * @author LiBingxiang
     * @date 2020/01/31 14:08:25
     */
    List<RestaurantDetails> getAllRestaurantDetails();

    /**
     * description: 根据餐厅订单id获取所有餐厅订单各个商品购买详情
     *
     * @param id 餐厅订单id
     * @return com.face.hotel.entity.RestaurantDetails
     * @author LiBingxiang
     * @date 2020/01/31 14:24:39
     */
    RestaurantDetails getRestaurantDetailsById(String id);

    /**
     * description: 新增餐厅订单各个商品购买详情
     *
     * @param userDetails 餐厅订单实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:19:36
     */
    String insertRestaurantDetails(RestaurantDetails userDetails) throws Exception;

    /**
     * description: 修改餐厅订单各个商品购买详情
     *
     * @param userDetails 餐厅订单实体类
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 15:32:52
     */
    String updateRestaurantDetails(RestaurantDetails userDetails) throws Exception;

    /**
     * description: 删除餐厅订单各个商品购买详情
     *
     * @param id 餐厅订单id
     * @return java.lang.String
     * @author LiBingxiang
     * @date 2020/01/31 16:23:33
     */
    String deleteRestaurantDetails(String id) throws Exception;

    /**
     * description: 根据订单id查询购买的所有商品详情
     *
     * @param userId 用户id
     * @return java.util.List<com.face.hotel.entity.RestaurantDetails>
     * @author LiBingxiang
     * @date 2020/02/01 14:25:41
     */
    List<RestaurantDetails> getRestaurantDetailsByUserId(String infoId);
}
