package com.face.hotel.mapper;

import com.face.hotel.entity.VehicleInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 上午11:49
 */
public interface VehicleInfoMapper extends Mapper<VehicleInfo> {

    List<VehicleInfo> selectAllVehicleInfo();

    /**
     * 得到最近一次进入该车位的停车记录信息
     * @param uid
     * @return
     */
    VehicleInfo selectLastVehicleIn(Long uid);

    /**
     * description: 查询停车时间
     *
     * @param userId 用户id
     * @return java.util.Date
     * @author LiBingxiang
     * @date 2020/02/05 15:41:02
     */
    String getHours(Long userId);

}
