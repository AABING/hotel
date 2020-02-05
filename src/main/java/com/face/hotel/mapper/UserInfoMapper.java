package com.face.hotel.mapper;

import com.face.hotel.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:47
 **/
public interface UserInfoMapper extends Mapper<UserInfo> {

    UserInfo getUserInfoByCardNumber(String cardNumber);

    UserInfo getUserInfoByFace(String faceMessage);
}
