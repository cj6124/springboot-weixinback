package com.wenjie.weixinback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chenwenjie
 */
@SpringBootApplication
@MapperScan(basePackages="com.wenjie.weixinback.mapper")
public class WeixinbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinbackApplication.class, args);
    }

}
