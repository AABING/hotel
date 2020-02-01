package com.face.hotel.service;

import com.face.hotel.entity.BillInfo;
import com.face.hotel.entity.RoomInfo;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午10:01
 **/
public interface BillInfoService {
    /**
    *@Author: NaiPan
    *@Description: 获取所有账单信息
    *@return: java.util.List<com.face.hotel.entity.BillInfo>
    *@date: 2020/1/31
    */
    List<BillInfo> getAllBillInfo();

    /**
    *@Author: NaiPan
    *@Description: 根据用户id获取该用户所有账单信息
    *@return: java.util.List<com.face.hotel.entity.BillInfo>
    *@date: 2020/1/31
    */
    List<BillInfo> getBillInfoByUserId(Long userId);

    /**
    *@Author: NaiPan
    *@Description: 新增账单信息
    *@Param: billInfo
    *@return: String
    *@date: 2020/2/1
    */
    String insertBillInfo(BillInfo billInfo) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 更新账单信息
    *@Param: billInfo
    *@return: String
    *@date: 2020/2/1
    */
    String updateBillInfo(BillInfo billInfo) throws Exception;

    /**
    *@Author: NaiPan
    *@Description: 删除账单信息
    *@Param: id
    *@return: String
    *@date: 2020/2/1
    */
    String deleteBillInfo(String id) throws Exception;
}
