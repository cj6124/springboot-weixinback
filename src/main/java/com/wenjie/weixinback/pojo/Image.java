package com.wenjie.weixinback.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Image {
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

    /**
     * 获取图片id
     *
     * @return image_id - 图片id
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * 设置图片id
     *
     * @param imageId 图片id
     */
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品id
     *
     * @param goodsId 商品id
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取图片url
     *
     * @return image_url - 图片url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片url
     *
     * @param imageUrl 图片url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取图片更新时间
     *
     * @return image_udtime - 图片更新时间
     */
    public Date getImageUdtime() {
        return imageUdtime;
    }

    /**
     * 设置图片更新时间
     *
     * @param imageUdtime 图片更新时间
     */
    public void setImageUdtime(Date imageUdtime) {
        this.imageUdtime = imageUdtime;
    }
}