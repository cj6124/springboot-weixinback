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
     * 图片的存放路径
     */
    private String imagepath;

    /**
     * 视频存放路径
     */
    private String videopath;
}
