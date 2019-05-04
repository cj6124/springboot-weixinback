package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.common.utils.CopyFileUtil;
import com.wenjie.weixinback.common.utils.DateUtil;
import com.wenjie.weixinback.common.utils.JsonResult;
import com.wenjie.weixinback.config.ResourcesPathConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


/**
 * @author chenwenjie
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class UpLoadController {

    @Autowired
    private ResourcesPathConfig resourcesPathConfig;

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

}
