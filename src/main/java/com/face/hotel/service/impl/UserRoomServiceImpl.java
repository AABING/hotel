package com.face.hotel.service.impl;

import com.face.hotel.entity.UserRoom;
import com.face.hotel.mapper.UserRoomMapper;
import com.face.hotel.service.UserRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:08
 */
@Service
@Slf4j
public class UserRoomServiceImpl implements UserRoomService {
    @Resource
    private UserRoomMapper userRoomMapper;

    @Override
    public List<UserRoom> getAllUserRoomInfo() {
        return userRoomMapper.selectAll();
    }

    @Override
    public UserRoom getUserRoomInfoById(String userId, String roomId) {
        return userRoomMapper.getUserRoomById(userId, roomId);
    }

    @Override
    public String insertUserRoomInfo(UserRoom userRoom) throws Exception {
        int result = userRoomMapper.insert(userRoom);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateUserRoomInfo(UserRoom userRoom) throws Exception {
        int result = userRoomMapper.updateByPrimaryKey(userRoom);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteUserRoomInfo(String userId, String roomId) throws Exception {
        int result = userRoomMapper.deleteUserRoomById(userId, roomId);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }
}
