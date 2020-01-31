package com.face.hotel.service;

import com.face.hotel.entity.BillInfo;

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


}
