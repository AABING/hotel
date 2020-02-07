package com.face.hotel.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Institution csust
 * @Author MeiyuJijieYihou
 * @Description Waiting fo development.
 * @Date 2020/2/4 下午11:06
 */
public class MultipartFileToFileUtil {

    /**
     * MultipartFile 转 File
     *
     * @param multipartFile
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile multipartFile) throws Exception {

        List<String> imgTypes = new ArrayList();
        // 支持"jpg", "jpeg", "png", "bmp", "gif"
        imgTypes.add("jpg");
        imgTypes.add("jpeg");
        imgTypes.add("png");
        imgTypes.add("bmp");
        imgTypes.add("gif");

        // 得到文件带后缀的名字
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件的后缀格式
        String faceSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        if (!imgTypes.contains(faceSuffix)) {
            throw new Exception("上传的文件不为图片，请重新上传！");
        }
        File file = null;
        if ("".equals(multipartFile) || multipartFile.getSize() <= 0) {
            multipartFile = null;
        } else {
            InputStream in = multipartFile.getInputStream();
            file = new File(fileName);
            inputStreamToFile(in, file);
            //in.close();
        }
        return file;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[2024*4];
            while ((bytesRead = in.read(buffer, 0, 2024*4)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}
