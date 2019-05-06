package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.common.utils.CopyFileUtil;
import com.wenjie.weixinback.common.utils.DateUtil;
import com.wenjie.weixinback.common.utils.FileRenameUtil;
import com.wenjie.weixinback.common.utils.JsonResult;
import com.wenjie.weixinback.config.ProjectUrlConfig;
import com.wenjie.weixinback.config.ResourcesPathConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author chenwenjie
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class UpLoadController {

    @Autowired
    private ResourcesPathConfig resourcesPathConfig;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    @PostMapping(value = "/uploadImage", headers = "content-type=multipart/form-data")
    public JsonResult uploadFile(MultipartFile pic) throws IOException {

        //设置目录
        String date = DateUtil.getDate();
        String path = resourcesPathConfig.getRealimagepath() + date;
        String returnPath = CopyFileUtil.copyFileToPath(date, pic, path);

        return JsonResult.ok(returnPath);
    }

    @PostMapping(value = "/uploadVideo", headers = "content-type=multipart/form-data")
    public JsonResult uploadVideo(MultipartFile video) throws IOException {
        //设置目录
        String date = DateUtil.getDate();
        String path = resourcesPathConfig.getRealvideopath() + date;
        String returnPath = CopyFileUtil.copyFileToPath(date, video, path);

        return JsonResult.ok(returnPath);
    }

    /**
     * 富文本的图片上传
     * @param upfile 表单中的参数名
     * @return 复合富文本的返回体
     * @throws IOException io异常
     * @link https://www.kancloud.cn/wangfupeng/wangeditor3/335782
     */
    @PostMapping("/uploadimage")
    public Map<String,Object> ueditorUpload(MultipartFile[] upfile) throws IOException {

        //设置返回集合
        List<String> list = new ArrayList<>();

        for(int i = 0; i < upfile.length; i++){
            //设置目录
            String date = DateUtil.getDate();
            String path = resourcesPathConfig.getRealimagepath() + date;
            String returnPath = CopyFileUtil.copyFileToPath(date, upfile[i], path);
            list.add(projectUrlConfig.getServerurl() + returnPath);
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("errno", "0");
        params.put("data", list);
        return params;
    }
}
