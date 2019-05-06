package com.wenjie.weixinback.vo;

import lombok.Data;
import java.io.Serializable;


/**
 * @author chenwenjie
 * @link https://www.layui.com/doc/modules/layer.html
 * json属性跟layer的相册返回格式对应
 *
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
