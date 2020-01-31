package com.face.hotel.mapper;

import com.face.hotel.entity.UserRoom;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting for development
 * @Date 2020/1/22 下午9:46
 **/
public interface UserRoomMapper extends Mapper<UserRoom> {

    UserRoom getUserRoomById(@Param("userId") String userId, @Param("roomId") String roomId);

    Integer deleteUserRoomById(@Param("userId") String userId, @Param("roomId") String roomId);
}
