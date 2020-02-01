package com.face.hotel.mapper;

import com.face.hotel.entity.RestaurantInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:47
 **/
public interface RestaurantInfoMapper extends Mapper<RestaurantInfo> {

    /**
     * description: 根据用户id获取餐厅账单信息
     *
     * @param userId 用户id
     * @return java.util.List<com.face.hotel.entity.RestaurantInfo>
     * @author LiBingxiang
     * @date 2020/02/01 14:28:19
     */
    List<RestaurantInfo> getRestaurantInfoByUserId(String userId);

}
