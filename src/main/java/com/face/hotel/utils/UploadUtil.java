package com.face.hotel.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/2/4 下午4:49
 */
public class UploadUtil {
    public final static String USER_FACE_PATH = "src/main/resources/user_info/faces";

    public final static String STAFF_FACE_PATH = "src/main/resources/staff_info/faces";


    /**
     * 用户上传人面信息
     * @param face
     * @throws Exception
     */
    public static void uploadUserFaceInfo(MultipartFile face) throws Exception {
        List<String> imgTypes = new ArrayList();
        // 支持"jpg", "jpeg", "png", "bmp", "gif"
        imgTypes.add("jpg");
        imgTypes.add("jpeg");
        imgTypes.add("png");
        imgTypes.add("bmp");
        imgTypes.add("gif");

        // 获取文件名，带后缀
        String faceName = face.getOriginalFilename();
        // 获取文件的后缀格式
        String faceSuffix = faceName.substring(faceName.lastIndexOf(".") + 1).toLowerCase();

        // 把相对路径转换为绝对路径
        File facePath = new File(USER_FACE_PATH);
        String faceLoadPath = facePath.getAbsolutePath() + File.separator + faceName;

        if (imgTypes.contains(faceSuffix)) {

            File destFile = new File(faceLoadPath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            //如果文件存在，删除原有文件
            if (destFile.exists() && destFile.isFile()) {
                destFile.delete();
            }

            try {
                face.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new Exception("上传人面信息格式不对！");
        }
    }

    /**
     * 员工上传人面信息
     * @param face
     * @throws Exception
     */
    public static void uploadStaffFaceInfo(MultipartFile face) throws Exception {
        List<String> imgTypes = new ArrayList();
        // 支持"jpg", "jpeg", "png", "bmp", "gif"
        imgTypes.add("jpg");
        imgTypes.add("jpeg");
        imgTypes.add("png");
        imgTypes.add("bmp");
        imgTypes.add("gif");

        // 获取文件名，带后缀
        String faceName = face.getOriginalFilename();
        // 获取文件的后缀格式
        String faceSuffix = faceName.substring(faceName.lastIndexOf(".") + 1).toLowerCase();

        // 把相对路径转换为绝对路径
        File facePath = new File(STAFF_FACE_PATH);
        String faceLoadPath = facePath.getAbsolutePath() + File.separator + faceName;

        if (imgTypes.contains(faceSuffix)) {

            File destFile = new File(faceLoadPath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            //如果文件存在，删除原有文件
            if (destFile.exists() && destFile.isFile()) {
                destFile.delete();
            }

            try {
                face.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new Exception("上传人面信息格式不对！");
        }
    }
}
