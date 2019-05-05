package com.wenjie.weixinback.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenwenjie
 * 项目的url配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectUrlConfig {
    private String serverurl;
}
