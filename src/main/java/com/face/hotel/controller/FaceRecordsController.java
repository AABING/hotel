package com.face.hotel.controller;

import com.face.hotel.entity.FaceRecords;
import com.face.hotel.pojo.Result;
import com.face.hotel.pojo.ResultCode;
import com.face.hotel.service.FaceRecordsService;
import com.sun.org.apache.xpath.internal.objects.XString;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/1/23 下午5:45
 */
@RestController
@Api("人面识别记录控制器")
@Slf4j
@RequestMapping("/faceRecord")
public class FaceRecordsController {

    @Resource
    FaceRecordsService faceRecordsService;


    @ApiOperation("得到所有的人面识别信息")
    @GetMapping("/get")
    public Result<List<FaceRecords>> getAllFaceRecords() {
        Result<List<FaceRecords>> result = new Result<>();

        try {
            List<FaceRecords> faceRecords = faceRecordsService.getAllFaceRecords();
            result.setData(faceRecords);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }

    @ApiOperation("根据ID查询得到面部识别记录信息")
    @GetMapping("/get/{id}")
    public Result<FaceRecords> getFaceRecords(@PathVariable Long id) {
        Result<FaceRecords> result = new Result<>();

        try {
            FaceRecords faceRecord = faceRecordsService.getFaceRecord(id);
            result.setData(faceRecord);
        } catch (Exception e) {
            result.setStatus(ResultCode.NOT_FIND);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("插入面部识别记录信息")
    @PostMapping("/insert")
    public Result<String> insertFaceRecord(FaceRecords faceRecords) {
        Result<String> result = new Result<>();

        try {
            String info = faceRecordsService.insertFaceRecord(faceRecords);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("更新人面识别记录信息")
    @PutMapping("/update")
    public  Result<String> updateFaceRecord(FaceRecords faceRecords) {
        Result<String> result = new Result<>();

        try {
            String info = faceRecordsService.updateFaceRecord(faceRecords);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }


    @ApiOperation("根据ID删除人面识别记录信息")
    @DeleteMapping("/delete/{id}")
    public  Result<String> deleteFaceRecord(@PathVariable Long id) {
        Result<String> result = new Result<>();

        try {
            String info = faceRecordsService.deleteFaceRecord(id);
            result.setData(info);
        } catch (Exception e) {
            result.setStatus(ResultCode.ERROR);
            result.setMassage(e.getMessage());
        }

        return result;
    }
}
