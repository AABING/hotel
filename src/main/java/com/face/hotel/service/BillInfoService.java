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

    /**
     *@Author: NaiPan
     *@Description: 新增账单
     *@return: java.util.List<com.face.hotel.entity.BillInfo>
     *@date: 2020/2/3
     */
    String insertBillInfo(BillInfo billInfo) throws Exception;

    /**
     *@Author: NaiPan
     *@Description: 修改账单
     *@return: java.util.List<com.face.hotel.entity.BillInfo>
     *@date: 2020/2/3
     */
    String updateBillInfo(BillInfo billInfo) throws Exception;

    /**
     *@Author: NaiPan
     *@Description: 删除账单
     *@return: java.util.List<com.face.hotel.entity.BillInfo>
     *@date: 2020/2/3
     */
    String deleteBillInfo(String id) throws Exception;

    /**
     * description: 查询未计入用户表的消费
     *
     * @param userId
     * @return java.lang.Integer
     * @author LiBingxiang
     * @date 2020/02/04 22:51:55
     */
    Double getBillDebt(Long userId);
}
