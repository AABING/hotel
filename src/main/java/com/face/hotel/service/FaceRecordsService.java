package com.face.hotel.service;

import com.face.hotel.entity.FaceRecords;

import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:20
 */
public interface FaceRecordsService {


    /**
     * 得到所有的所有的面部识别记录
     * @return
     */
    List<FaceRecords> getAllFaceRecords();


    /**
     * 根据ID得到人面识别记录信息
     * @return
     */
    FaceRecords getFaceRecord(Long id);


    /**
     * 插入人面识别记录信息
     * @return
     */
    String insertFaceRecord(FaceRecords faceRecords) throws Exception;


    /**
     * 更新人面识别记录信息
     * @param faceRecords
     * @return
     */
    String updateFaceRecord(FaceRecords faceRecords) throws Exception;


    /**
     * 根据ID删除人面识别记录信息
     * @param id
     * @return
     */
    String deleteFaceRecord(Long id) throws Exception;

}
