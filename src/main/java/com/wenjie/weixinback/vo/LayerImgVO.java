package com.wenjie.weixinback.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenwenjie
 * json属性跟layer的相册返回格式对应
 */
@Data
public class LayerImgVO implements Serializable {

    /**
     * 图片id
     */
    private String pid;

    /**
     * 图片url
     */
    private String src;

    /**
     * 图片略缩图url
     */
    private String thumb;

    /**
     * 图片名
     */
    private String alt;




}
