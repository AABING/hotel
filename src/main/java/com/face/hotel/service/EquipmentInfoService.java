package com.face.hotel.service;

import com.face.hotel.entity.EquipmentInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:19
 */
public interface EquipmentInfoService {


    /**
     * 得到所有的人面识别设备的信息
     * @return
     */
    List<EquipmentInfo> getAllEquipmentInfo();


    /**
     * 根据Id得到设备信息
     * @param id
     * @return
     */
    EquipmentInfo getEquipmentById(Long id);


    /**
     * 插入设备识别设备信息
     * @return
     */
    String insertEquipmentInfo(EquipmentInfo equipmentInfo) throws Exception;


    /**
     * 更新人面识别设备信息
     * @param equipmentInfo
     * @return
     */
    String updateEquipmentInfo(EquipmentInfo equipmentInfo) throws Exception;


    /**
     * 删除人面识别设备信息
     * @param id
     * @return
     */
    String deleteEquipmentInfo(Long id) throws Exception;
}
