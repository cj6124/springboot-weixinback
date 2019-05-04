package com.wenjie.weixinback.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenwenjie
 */
@Data
@Component
@ConfigurationProperties(prefix = "resource")
public class ResourcesPathConfig {
    /**
     * 图片存放虚拟目录
     */
    private String virtulimagepath;

    /**
     * 视频存放虚拟目录
     */
    private String virtulvideopath;

    /**
     * 图片存放真实目录
     */
    private String realimagepath;

    /**
     * 视频存放真实目录
     */
    private String realvideopath;
}
