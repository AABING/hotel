package com.face.hotel.component;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageInfo;
import com.face.hotel.controller.FaceRecordsController;
import com.face.hotel.controller.StaffController;
import com.face.hotel.controller.UserController;
import com.face.hotel.entity.FaceRecords;
import com.face.hotel.entity.StaffInfo;
import com.face.hotel.entity.UserInfo;
import com.face.hotel.pojo.Result;
import com.face.hotel.utils.MultipartFileToFileUtil;
import com.face.hotel.utils.UploadUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/2/4 下午6:11
 */
@Component
public class FaceRecognitionComponent {

    @Resource
    private FaceRecordsController faceRecordsController;

    @Resource
    private UserController userController;

    @Resource
    private StaffController staffController;

    private FaceEngine faceEngine = null;

    /**
     * 初始化人面识别的引擎
     */
    private void doIniFacetEngine() {
        String appId = "Ao18aYt1HuTvLjMJ2i2wmpVbv9JsCWMFMMn2Z4rsvB5K";
        String sdkKey = "C2ABrNmrLyg25LdrAjNaFsbH1MJHVz3thF4Lh5co9cEe";

        faceEngine = new FaceEngine(System.getProperty("user.dir") + "/lib/engine");
        //激活引擎
        int activeCode = faceEngine.activeOnline(appId, sdkKey);

        if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("引擎激活失败");
        }

        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);

        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);


        //初始化引擎
        int initCode = faceEngine.init(engineConfiguration);

        if (initCode != ErrorInfo.MOK.getValue()) {
            System.out.println("初始化引擎失败");
        }
    }


    /**
     * 根据用户ID进行人面识别
     * @param uid
     * @param face2Info
     * @return
     * @throws Exception
     */
    public Boolean userFaceRecognition(Long uid, MultipartFile face2Info) throws Exception {

        Boolean result = false;

        // ①得到人面信息
        String face1Name = null;
        try {
            Result<UserInfo> userInfo = userController.getUserInfoById(uid.toString());
            System.out.println(userInfo);
            face1Name = userInfo.getData().getFace();
        } catch (Exception e) {
            throw new Exception("用户不存在!");
        }

        // 判断当前用户是否录入人面信息。
        if (null == face1Name) {
            throw new Exception("当前用户暂未录入人面信息！");
        }
        // 初始化引擎
        if (null == faceEngine) {
            doIniFacetEngine();
        }

        // 得到上传的人面信息零时文件
        File face2 = null;
        try {
            face2 = MultipartFileToFileUtil.multipartFileToFile(face2Info);
        } catch (Exception e) {
            throw new Exception("人面信息格式非法，请重新上传！");
        }

        // 人脸检测
        // 得到用户face信息在服务器上的位置
        String face1Path = UploadUtil.USER_FACE_PATH + File.separator +face1Name;
        ImageInfo imageInfo = getRGBData(new File(face1Path));
        if (null == imageInfo) {
            // 删除人面识别零时文件
            MultipartFileToFileUtil.delteTempFile(face2);
            throw new Exception("当前用户录入的人面信息有误！");
        }
        List<FaceInfo> faceInfoList = new ArrayList<>();
        int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
        System.out.println(faceInfoList);

        // 特征提取
        FaceFeature faceFeature = new FaceFeature();
        int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
        System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        // 人脸检测2
        ImageInfo imageInfo2 = getRGBData(face2);
        // 删除人面识别零时文件
        MultipartFileToFileUtil.delteTempFile(face2);
        List<FaceInfo> faceInfoList2 = new ArrayList<>();
        int detectCode2 = faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2);
        System.out.println(faceInfoList);

        // 特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        int extractCode2 = faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2.get(0), faceFeature2);
        System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        // 特征比对
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
        FaceSimilar faceSimilar = new FaceSimilar();
        int compareCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
        System.out.println("相似度：" + faceSimilar.getScore());


        // 人脸属性检测属性设置
        FunctionConfiguration configuration = new FunctionConfiguration();
        configuration.setSupportAge(true);
        configuration.setSupportFace3dAngle(true);
        configuration.setSupportGender(true);
        configuration.setSupportLiveness(true);
        int processCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, configuration);

        // 活体检测
        List<LivenessInfo> livenessInfoList = new ArrayList<>();
        int livenessCode = faceEngine.getLiveness(livenessInfoList);
        System.out.println("活体：" + livenessInfoList.get(0).getLiveness());

        // 如果相似度大于0.75，并且活体检测为1，则人面识别通过。
        if (faceSimilar.getScore() > 0.75 && livenessInfoList.get(0).getLiveness() == 1) {
            result = true;
        }

        // 记录本次面部识别信息
        FaceRecords faceRecord = new FaceRecords();
        faceRecord.setFaceInfo(face1Name);
        faceRecord.setPass(result);
        faceRecord.setTime(new Date());
        faceRecord.setUserId(uid);
        faceRecordsController.insertFaceRecord(faceRecord);

        return result;
    }

    /**
     * 员工人面识别
     * @param sId
     * @param face2Info
     * @return
     * @throws Exception
     */
    public Boolean staffFaceRecognition(Long sId, MultipartFile face2Info) throws Exception {

        Boolean result = false;

        // ①得到人面信息
        String face1Name = null;
        try {
            Result<StaffInfo> staffInfo = staffController.getStaffInfoById(sId.toString());
            face1Name = staffInfo.getData().getFace();
        } catch (Exception e) {
            throw new Exception("员工不存在!");
        }

        // 判断当前用户是否录入人面信息。
        if (null == face1Name) {
            throw new Exception("当前员工暂未录入人面信息！");
        }
        // 初始化引擎
        if (null == faceEngine) {
            doIniFacetEngine();
        }

        // 得到上传的人面信息零时文件
        File face2 = null;
        try {
            face2 = MultipartFileToFileUtil.multipartFileToFile(face2Info);
        } catch (Exception e) {
            throw new Exception("人面信息格式非法，请重新上传！");
        }

        // 人脸检测
        // 得到用户face信息在服务器上的位置
        String face1Path = UploadUtil.USER_FACE_PATH + File.separator +face1Name;
        ImageInfo imageInfo = getRGBData(new File(face1Path));
        if (null == imageInfo) {
            // 删除人面识别零时文件
            MultipartFileToFileUtil.delteTempFile(face2);
            throw new Exception("当前员工录入的人面信息有误！");
        }
        List<FaceInfo> faceInfoList = new ArrayList<>();
        int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
        System.out.println(faceInfoList);

        // 特征提取
        FaceFeature faceFeature = new FaceFeature();
        int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
        System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        // 人脸检测2
        ImageInfo imageInfo2 = getRGBData(face2);
        // 删除人面识别零时文件
        MultipartFileToFileUtil.delteTempFile(face2);
        List<FaceInfo> faceInfoList2 = new ArrayList<>();
        int detectCode2 = faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2);
        System.out.println(faceInfoList);

        // 特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        int extractCode2 = faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2.get(0), faceFeature2);
        System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

        // 特征比对
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
        FaceSimilar faceSimilar = new FaceSimilar();
        int compareCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
        System.out.println("相似度：" + faceSimilar.getScore());


        // 人脸属性检测属性设置
        FunctionConfiguration configuration = new FunctionConfiguration();
        configuration.setSupportAge(true);
        configuration.setSupportFace3dAngle(true);
        configuration.setSupportGender(true);
        configuration.setSupportLiveness(true);
        int processCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, configuration);

        // 活体检测
        List<LivenessInfo> livenessInfoList = new ArrayList<>();
        int livenessCode = faceEngine.getLiveness(livenessInfoList);
        System.out.println("活体：" + livenessInfoList.get(0).getLiveness());

        // 如果相似度大于0.75，并且活体检测为1，则人面识别通过。
        if (faceSimilar.getScore() > 0.75 && livenessInfoList.get(0).getLiveness() == 1) {
            result = true;
        }

        // 记录本次面部识别信息
        FaceRecords faceRecord = new FaceRecords();
        faceRecord.setFaceInfo(face1Name);
        faceRecord.setPass(result);
        faceRecord.setTime(new Date());
        faceRecord.setStaffId(sId);
        faceRecordsController.insertFaceRecord(faceRecord);

        return result;
    }

    /**
     * 根据员工人面信息得到员工信息
     * @param face2Info
     * @return
     * @throws Exception
     */
    public StaffInfo staffFaceCheckInfo(MultipartFile face2Info) throws Exception {

        // 得到上传的人面信息零时文件
        File face2 = null;
        try {
            face2 = MultipartFileToFileUtil.multipartFileToFile(face2Info);
        } catch (Exception e) {
            throw new Exception("人面信息格式非法，请重新上传！");
        }
        // 初始化引擎
        if (null == faceEngine) {
            doIniFacetEngine();
        }
        // 人脸检测2
        ImageInfo imageInfo2 = getRGBData(face2);
        // 删除人面识别零时文件
        MultipartFileToFileUtil.delteTempFile(face2);
        List<FaceInfo> faceInfoList2 = new ArrayList<>();
        int detectCode2 = faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2);
        // System.out.println(faceInfoList2);
        // 特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        int extractCode2 = faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList2.get(0), faceFeature2);
        // System.out.println("特征值大小：" + faceFeature2.getFeatureData().length);

        // 便利全体员工，得到每一个员工的人面信息
        List<StaffInfo> staffs = staffController.getAllStaffInfo().getData();
        for (StaffInfo staff: staffs) {
            // 得到该员工的人面信息
            String face1Name = null;
            face1Name = staff.getFace();
            if (null ==face1Name) {
                // 如果检测到当前员工没有Face信息，则跳过该员工
                System.out.println("Staff: " + staff.getId() + " face info is null.");
                continue;
            }
            // 人脸检测
            // 得到员工face信息在服务器上的位置
            String face1Path = UploadUtil.STAFF_FACE_PATH + File.separator +face1Name;
            ImageInfo imageInfo = getRGBData(new File(face1Path));
            List<FaceInfo> faceInfoList = new ArrayList<>();
            int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
            // System.out.println(faceInfoList);

            // 特征提取
            FaceFeature faceFeature = new FaceFeature();
            int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
            // System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

            // 特征比对
            FaceFeature targetFaceFeature = new FaceFeature();
            targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
            FaceFeature sourceFaceFeature = new FaceFeature();
            sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
            FaceSimilar faceSimilar = new FaceSimilar();
            int compareCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
            System.out.println("Staff" + staff.getId() + "相似度：" + faceSimilar.getScore());

            // 人脸属性检测属性设置
            FunctionConfiguration configuration = new FunctionConfiguration();
            configuration.setSupportAge(true);
            configuration.setSupportFace3dAngle(true);
            configuration.setSupportGender(true);
            configuration.setSupportLiveness(true);
            int processCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList, configuration);

            // 活体检测
            List<LivenessInfo> livenessInfoList = new ArrayList<>();
            int livenessCode = faceEngine.getLiveness(livenessInfoList);
            // System.out.println("活体：" + livenessInfoList.get(0).getLiveness());

            // 如果相似度大于0.75，并且活体检测为1，则人面识别通过。
            if (faceSimilar.getScore() > 0.75 && livenessInfoList.get(0).getLiveness() == 1) {
                return staff;
            }
        }

        return null;
    }

    /**
     * 卸载人面识别引擎
     */
    private void unInitFaceEngine() {
        //引擎卸载
        int unInitCode = faceEngine.unInit();
    }
}

