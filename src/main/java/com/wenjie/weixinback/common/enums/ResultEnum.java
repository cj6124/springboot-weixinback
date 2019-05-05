package com.wenjie.weixinback.common.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author chenwenjie
 */

@Getter
public enum ResultEnum implements Serializable {

    SUCCESS(0, "操作成功"),

    UPLOAD_ERROR(1, "上传失败"),

    PRICE_ERROR(2, "折扣价大于原价"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
