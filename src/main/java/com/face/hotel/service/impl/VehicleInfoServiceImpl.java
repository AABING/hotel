package com.face.hotel.service.impl;

import com.face.hotel.entity.VehicleInfo;
import com.face.hotel.mapper.VehicleInfoMapper;
import com.face.hotel.service.VehicleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:23
 */
@Service
@Slf4j
public class VehicleInfoServiceImpl implements VehicleInfoService {


    @Resource
    VehicleInfoMapper vehicleInfoMapper;

    public List<VehicleInfo> getAllVehicleInfo() {

        List<VehicleInfo> vehicleInfos = vehicleInfoMapper.selectAllVehicleInfo();
        return vehicleInfos;
    }

    @Override
    public VehicleInfo getVehicleInfoById(Long id) {
        return vehicleInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateVehicleInfo(VehicleInfo vehicleInfo) throws Exception {
        int result = vehicleInfoMapper.updateByPrimaryKey(vehicleInfo);
        if (1 != result) {
            throw new Exception("修改停车信息失败！");
        }
        return "修改停车信息成功";
    }

    @Override
    public String insertVehicleInfo(VehicleInfo vehicleInfo) throws Exception {

        int result = vehicleInfoMapper.insert(vehicleInfo);

        if (1 != result) {
            throw new Exception("插入停车信息失败！");
        }
        return "插入停车信息成功";
    }

    @Override
    public String deleteVehicleInfo(Long id) throws Exception {

        int result = vehicleInfoMapper.deleteByPrimaryKey(id);

        if (1 != result) {
            throw new Exception("删除停车信息失败！");
        }

        return "删除停车信息成功！";
    }

    @Override
    public VehicleInfo getLastVehicleIn(Long uid) {
        VehicleInfo vehicleInfo = vehicleInfoMapper.selectLastVehicleIn(uid);
        return vehicleInfo;
    }


}
