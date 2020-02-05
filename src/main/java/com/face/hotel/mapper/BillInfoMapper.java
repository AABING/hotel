package com.face.hotel.mapper;

import com.face.hotel.entity.BillInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:48
 **/
public interface BillInfoMapper extends Mapper<BillInfo> {

    /**
    *@Author: NaiPan
    *@Description: 通过userId获取该用户所有账单
    *@Param: userId
    *@return: java.util.List<com.face.hotel.entity.BillInfo>
    *@date: 2020/1/31
    */
    List<BillInfo> selectBillInfoByUserId(Long userId);

    /**
     * description: 查询是否有未计入用户表的消费
     *
     * @param userId 用户id
     * @return java.lang.Integer
     * @author LiBingxiang
     * @date 2020/02/05 14:09:56
     */
    Integer getBillDebt(Long userId);
}
