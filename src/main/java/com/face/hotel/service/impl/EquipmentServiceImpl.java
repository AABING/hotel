package com.face.hotel.service.impl;

import com.face.hotel.entity.EquipmentInfo;
import com.face.hotel.mapper.EquipmentInfoMapper;
import com.face.hotel.service.EquipmentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:21
 */
@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentInfoService {

    @Resource
    EquipmentInfoMapper equipmentInfoMapper;

    @Override
    public List<EquipmentInfo> getAllEquipmentInfo() {

        return equipmentInfoMapper.selectAll();
    }

    @Override
    public EquipmentInfo getEquipmentById(Long id) {
        return equipmentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertEquipmentInfo(EquipmentInfo equipmentInfo) throws Exception {

        int result = equipmentInfoMapper.insert(equipmentInfo);

        if (1 != result) {
            throw new Exception("插入设备信息异常！");
        }

        return "插入设备信息成功！";
    }

    @Override
    public String updateEquipmentInfo(EquipmentInfo equipmentInfo) throws Exception {

        int result = equipmentInfoMapper.updateByPrimaryKey(equipmentInfo);
        if (1 != result) {
            throw new Exception("更新人面识别设备信息失败！");
        }

        return "更新人面识别设备信息成功";
    }

    @Override
    public String deleteEquipmentInfo(Long id) throws Exception {

        int result = equipmentInfoMapper.deleteByPrimaryKey(id);
        if (1 != result) {
            throw new Exception("删除人面识别设备信息失败！");
        }

        return "删除人面识别设备信息成功！";
    }


}
