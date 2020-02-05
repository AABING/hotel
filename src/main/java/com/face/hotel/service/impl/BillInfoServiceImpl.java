package com.face.hotel.service.impl;

import com.face.hotel.entity.BillInfo;
import com.face.hotel.mapper.BillInfoMapper;
import com.face.hotel.service.BillInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:04
 */
@Service
public class BillInfoServiceImpl implements BillInfoService {

    @Resource
    BillInfoMapper billInfoMapper;

    @Override
    public List<BillInfo> getAllBillInfo() {
        return billInfoMapper.selectAll();
    }

    @Override
    public List<BillInfo> getBillInfoByUserId(Long userId) {
        return billInfoMapper.selectBillInfoByUserId(userId);
    }

    @Override
    public Integer getBillDebt(Long userId) {
        return billInfoMapper.getBillDebt(userId);
    }
}
