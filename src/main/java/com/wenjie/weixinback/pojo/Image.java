package com.wenjie.weixinback.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenwenjie
 */
@Data
public class Image implements Serializable {
    /**
     * 图片id
     */
    @Id
    @Column(name = "image_id")
    private String imageId;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 图片url
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 图片更新时间
     */
    @Column(name = "image_udtime")
    private Date imageUdtime;
}