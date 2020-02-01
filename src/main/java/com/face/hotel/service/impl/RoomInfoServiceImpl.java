package com.face.hotel.service.impl;

import com.face.hotel.entity.RoomInfo;
import com.face.hotel.mapper.RoomInfoMapper;
import com.face.hotel.service.RoomInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:06
 */
@Service
public class RoomInfoServiceImpl implements RoomInfoService {
    @Resource
    RoomInfoMapper roomInfoMapper;

    @Override
    public List<RoomInfo> getAllRoomInfo() {
        return roomInfoMapper.selectAll();
    }

    @Override
    public RoomInfo getRoomInfoById(String id) {
        return roomInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertRoomInfo(RoomInfo roomInfo) throws Exception {
        int result = roomInfoMapper.insert(roomInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateRoomInfo(RoomInfo roomInfo) throws Exception {
        int result = roomInfoMapper.updateByPrimaryKeySelective(roomInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteRoomInfo(String id) throws Exception {
        int result = roomInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }
}
