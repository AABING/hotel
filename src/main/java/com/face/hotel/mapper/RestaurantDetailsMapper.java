package com.face.hotel.mapper;

import com.face.hotel.entity.RestaurantDetails;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:47
 **/
public interface RestaurantDetailsMapper extends Mapper<RestaurantDetails> {

    /**
     * description: 根据订单id获取餐厅账单内的所有商品详情
     *
     * @param infoId 订单id
     * @return java.util.List<com.face.hotel.entity.RestaurantDetails>
     * @author LiBingxiang
     * @date 2020/02/01 15:24:58
     */
    List<RestaurantDetails> getRestaurantDetailsByUserId(String infoId);

}
