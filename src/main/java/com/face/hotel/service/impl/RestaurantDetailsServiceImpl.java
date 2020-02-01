package com.face.hotel.service.impl;

import com.face.hotel.entity.RestaurantDetails;
import com.face.hotel.mapper.RestaurantDetailsMapper;
import com.face.hotel.service.RestaurantDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/22 下午10:05
 */
@Service
public class RestaurantDetailsServiceImpl implements RestaurantDetailsService {
    @Resource
    private RestaurantDetailsMapper restaurantDetailsMapper;

    @Override
    public List<RestaurantDetails> getAllRestaurantDetails() {
        return restaurantDetailsMapper.selectAll();
    }

    @Override
    public RestaurantDetails getRestaurantDetailsById(String id) {
        return restaurantDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertRestaurantDetails(RestaurantDetails restaurantDetails) throws Exception {
        int result = restaurantDetailsMapper.insert(restaurantDetails);
        if (result != 1) {
            throw new Exception("新增失败");
        }
        return "新增成功";
    }

    @Override
    public String updateRestaurantDetails(RestaurantDetails restaurantDetails) throws Exception {
        int result = restaurantDetailsMapper.updateByPrimaryKeySelective(restaurantDetails);
        if (result != 1) {
            throw new Exception("修改失败");
        }
        return "修改成功";
    }

    @Override
    public String deleteRestaurantDetails(String id) throws Exception {
        int result = restaurantDetailsMapper.deleteByPrimaryKey(id);
        if (result != 1) {
            throw new Exception("删除失败");
        }
        return "删除成功";
    }

    @Override
    public List<RestaurantDetails> getRestaurantDetailsByUserId(String infoId) {
        return restaurantDetailsMapper.getRestaurantDetailsByUserId(infoId);
    }
}
