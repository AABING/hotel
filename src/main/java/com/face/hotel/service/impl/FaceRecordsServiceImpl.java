package com.face.hotel.service.impl;

import com.face.hotel.entity.FaceRecords;
import com.face.hotel.mapper.FaceRecordsMapper;
import com.face.hotel.service.FaceRecordsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:22
 */
@Service
public class FaceRecordsServiceImpl implements FaceRecordsService {

    @Resource
    FaceRecordsMapper faceRecordsMapper;

    @Override
    public List<FaceRecords> getAllFaceRecords() {

        return faceRecordsMapper.selectAll();
    }

    @Override
    public FaceRecords getFaceRecord(Long id) {
        return faceRecordsMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertFaceRecord(FaceRecords faceRecords) throws Exception {

        int insert = faceRecordsMapper.insert(faceRecords);

        if (1 != insert) {
            throw new Exception("插入人面识别信息失败！");
        }

        return "插入人面识别信息成功！";
    }

    @Override
    public String updateFaceRecord(FaceRecords faceRecords) throws Exception {

        int update = faceRecordsMapper.updateByPrimaryKey(faceRecords);

        if (1 != update) {
            throw new Exception("更新人面识别信息出错！");
        }

        return "更新人面识别信息成功！";
    }

    @Override
    public String deleteFaceRecord(Long id) throws Exception {

        int delete = faceRecordsMapper.deleteByPrimaryKey(id);

        if (1 != delete) {
            throw new Exception("删除人面识别信息异常！");
        }

        return "删除人面识别信息成功！";
    }

}
