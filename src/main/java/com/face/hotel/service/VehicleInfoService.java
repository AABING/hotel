package com.face.hotel.service;

import com.face.hotel.entity.VehicleInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:21
 */
public interface VehicleInfoService {
    /**
     * 得到所有的停车信息
     * @return
     */
    List<VehicleInfo> getAllVehicleInfo();


    /**
     * 根据ID得到停车记录信息
     * @return
     */
    VehicleInfo getVehicleInfoById(Long id);


    /**
     * 更新停车信息
     * @param vehicleInfo
     * @return
     * @throws Exception
     */
    String updateVehicleInfo(VehicleInfo vehicleInfo) throws Exception;


    /**
     * 插入停车信息
     * @param vehicleInfo
     * @return
     * @throws Exception
     */
    String insertVehicleInfo(VehicleInfo vehicleInfo) throws Exception;


    /**
     * 根据停车信息ID删除停车信息
     * @param id
     * @return
     * @throws Exception
     */
    String deleteVehicleInfo(Long id) throws Exception;

    /**
     * 得到最近一次进入该车位的停车记录信息
     * @param uid
     * @return
     */
    VehicleInfo getLastVehicleIn(Long uid);
    VehicleInfo getVehicleInfo(Long userId);
}
