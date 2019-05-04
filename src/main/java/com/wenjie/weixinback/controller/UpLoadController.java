package com.wenjie.weixinback.controller;

import com.baidu.ueditor.ActionEnter;
import com.wenjie.weixinback.common.utils.CopyFileUtil;
import com.wenjie.weixinback.common.utils.DateUtil;
import com.wenjie.weixinback.common.utils.FileRenameUtil;
import com.wenjie.weixinback.common.utils.JsonResult;
import com.wenjie.weixinback.config.ResourcesPathConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
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

    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    @PostMapping("uploadimage")
    public Map<String,Object> ueditorUpload(MultipartFile upfile) throws IOException {
        //设置目录
        String date = DateUtil.getDate();
        String path = resourcesPathConfig.getRealimagepath() + date;
        // 如果日期目录不存在,创建文件夹
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //重置文件名
        String fileName = FileRenameUtil.renameFileName(upfile.getOriginalFilename());
        //返回给前端的路径
        String returnPath = date + "/" + fileName;

        //保存文件
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            String finalPath = path + "/" + fileName;
            File file = new File(finalPath);
            fileOutputStream = new FileOutputStream(file);
            inputStream = upfile.getInputStream();
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

        //设置返回集合
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("state", "SUCCESS");
        params.put("url", returnPath);
        params.put("title", fileName);
//        params.put("size", upfile.getSize());
        params.put("original", fileName);
//        params.put("type", upfile.getContentType());
        return params;
    }
}
