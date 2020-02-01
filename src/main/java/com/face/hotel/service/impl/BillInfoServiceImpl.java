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
    public String insertBillInfo(BillInfo billInfo) throws Exception {
        int result = billInfoMapper.insert(billInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateBillInfo(BillInfo billInfo) throws Exception {
        int result = billInfoMapper.updateByPrimaryKeySelective(billInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteBillInfo(String id) throws Exception {
        int result = billInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }


}
