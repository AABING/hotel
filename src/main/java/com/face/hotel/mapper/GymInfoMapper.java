package com.face.hotel.mapper;

import com.face.hotel.entity.GymInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:55
 **/
public interface GymInfoMapper extends Mapper<GymInfo> {
    /**
     * @Author: naipan
     * @Date: 2020/2/4 21:09
     * @Class_name: GymInfoMapper
     * @Description: 获取最后一次健身房消费记录
     */
    GymInfo getLastGymInfo(Long uid);
}
