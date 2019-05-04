package com.wenjie.weixinback.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author chenwenjie
 */
@Component
@Getter
public class SessionKeyConfig {
    private String userKeyPrefix = "ADMIN_REDIS_SESSION:";
}
