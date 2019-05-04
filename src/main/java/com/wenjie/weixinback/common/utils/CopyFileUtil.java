package com.wenjie.weixinback.common.utils;

import com.wenjie.weixinback.common.enums.ResultEnum;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenwenjie
 * 用于文件拷贝/上传的工具类
 */
public class CopyFileUtil {


    /**
     * @param date 一个日期
     * @param sourceFile 源文件
     * @param path 文件目录的绝对路径
     * @return returnPath 返回给前端拼接的地址
     * @throws IOException io异常
     */
    public static String copyFileToPath(String date, MultipartFile sourceFile, String path) throws IOException {
        // 如果日期目录不存在,创建文件夹
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //重置文件名
        String picName = FileRenameUtil.renameFileName(sourceFile.getOriginalFilename());
        //返回给前端的路径
        String returnPath = date + "/" + picName;

        //保存文件
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            String finalPath = path + "/" + picName;
            File file = new File(finalPath);
            fileOutputStream = new FileOutputStream(file);
            inputStream = sourceFile.getInputStream();
            IOUtils.copy(inputStream, fileOutputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if (null != fileOutputStream && null != inputStream){
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }
        }
        return returnPath;
    }
}
