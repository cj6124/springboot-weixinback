package com.wenjie.weixinback.common.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author chenwenjie
 */

@Getter
public enum ResultEnum implements Serializable {

    SUCCESS(0, "成功"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
