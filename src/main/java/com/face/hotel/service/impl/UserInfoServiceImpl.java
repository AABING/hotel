package com.face.hotel.service.impl;

import com.face.hotel.entity.UserInfo;
import com.face.hotel.mapper.UserInfoMapper;
import com.face.hotel.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:07
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertUserInfo(UserInfo userInfo) throws Exception {
        int result = userInfoMapper.insert(userInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateUserInfo(UserInfo userInfo) throws Exception {
        int result = userInfoMapper.updateByPrimaryKey(userInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteUserInfo(String id) throws Exception {
        int result = userInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }
}
