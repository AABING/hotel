package com.face.hotel.service.impl;

import com.face.hotel.entity.RestaurantInfo;
import com.face.hotel.mapper.RestaurantInfoMapper;
import com.face.hotel.service.RestaurantInfoService;
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
public class RestaurantInfoServiceImpl implements RestaurantInfoService {
    @Resource
    private RestaurantInfoMapper restaurantInfoMapper;

    @Override
    public List<RestaurantInfo> getAllRestaurantInfo() {
        return restaurantInfoMapper.selectAll();
    }

    @Override
    public RestaurantInfo getRestaurantInfoById(String id) {
        return restaurantInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertRestaurantInfo(RestaurantInfo restaurantInfo) throws Exception {
        int result = restaurantInfoMapper.insert(restaurantInfo);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateRestaurantInfo(RestaurantInfo restaurantInfo) throws Exception {
        int result = restaurantInfoMapper.updateByPrimaryKeySelective(restaurantInfo);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteRestaurantInfo(String id) throws Exception {
        int result = restaurantInfoMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }

    @Override
    public List<RestaurantInfo> getRestaurantInfoByUserId(String userId) {
        return restaurantInfoMapper.getRestaurantInfoByUserId(userId);
    }
}
