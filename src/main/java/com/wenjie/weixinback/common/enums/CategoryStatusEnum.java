package com.wenjie.weixinback.common.enums;

import lombok.Getter;

import java.io.Serializable;


/**
 * @author chenwenjie
 */

@Getter
public enum CategoryStatusEnum implements CodeEnum, Serializable {
    DISABLED(0, "禁用"),
    ACTIVE(1, "开启")
    ;

    private Integer code;

    private String message;

    CategoryStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
