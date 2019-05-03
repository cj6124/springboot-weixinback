package com.wenjie.weixinback.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    /**
     * 商品id
     */
    @Id
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品所属分类id
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品视频url
     */
    @Column(name = "goods_videourl")
    private String goodsVideourl;

    /**
     * 商品封面
     */
    @Column(name = "goods_picurl")
    private String goodsPicurl;

    /**
     * 商品原价(之后在精选页面才会显示原价)
     */
    @Column(name = "goods_originalprice")
    private BigDecimal goodsOriginalprice;

    /**
     * 商品折扣价
     */
    @Column(name = "goods_minprice")
    private BigDecimal goodsMinprice;

    /**
     * 商品简述(只有在精选页面才显示)
     */
    @Column(name = "goods_characteristic")
    private String goodsCharacteristic;

    /**
     * 商品介绍(富文本)
     */
    @Column(name = "goods_content")
    private String goodsContent;

    /**
     * 商品状态(0禁用1启用)
     */
    @Column(name = "goods_status")
    private Byte goodsStatus;

    /**
     * 商品更新时间
     */
    @Column(name = "goods_udtime")
    private Date goodsUdtime;

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
     * 获取商品所属分类id
     *
     * @return category_id - 商品所属分类id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品所属分类id
     *
     * @param categoryId 商品所属分类id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取商品视频url
     *
     * @return goods_videourl - 商品视频url
     */
    public String getGoodsVideourl() {
        return goodsVideourl;
    }

    /**
     * 设置商品视频url
     *
     * @param goodsVideourl 商品视频url
     */
    public void setGoodsVideourl(String goodsVideourl) {
        this.goodsVideourl = goodsVideourl;
    }

    /**
     * 获取商品封面
     *
     * @return goods_picurl - 商品封面
     */
    public String getGoodsPicurl() {
        return goodsPicurl;
    }

    /**
     * 设置商品封面
     *
     * @param goodsPicurl 商品封面
     */
    public void setGoodsPicurl(String goodsPicurl) {
        this.goodsPicurl = goodsPicurl;
    }

    /**
     * 获取商品原价(之后在精选页面才会显示原价)
     *
     * @return goods_originalprice - 商品原价(之后在精选页面才会显示原价)
     */
    public BigDecimal getGoodsOriginalprice() {
        return goodsOriginalprice;
    }

    /**
     * 设置商品原价(之后在精选页面才会显示原价)
     *
     * @param goodsOriginalprice 商品原价(之后在精选页面才会显示原价)
     */
    public void setGoodsOriginalprice(BigDecimal goodsOriginalprice) {
        this.goodsOriginalprice = goodsOriginalprice;
    }

    /**
     * 获取商品折扣价
     *
     * @return goods_minprice - 商品折扣价
     */
    public BigDecimal getGoodsMinprice() {
        return goodsMinprice;
    }

    /**
     * 设置商品折扣价
     *
     * @param goodsMinprice 商品折扣价
     */
    public void setGoodsMinprice(BigDecimal goodsMinprice) {
        this.goodsMinprice = goodsMinprice;
    }

    /**
     * 获取商品简述(只有在精选页面才显示)
     *
     * @return goods_characteristic - 商品简述(只有在精选页面才显示)
     */
    public String getGoodsCharacteristic() {
        return goodsCharacteristic;
    }

    /**
     * 设置商品简述(只有在精选页面才显示)
     *
     * @param goodsCharacteristic 商品简述(只有在精选页面才显示)
     */
    public void setGoodsCharacteristic(String goodsCharacteristic) {
        this.goodsCharacteristic = goodsCharacteristic;
    }

    /**
     * 获取商品介绍(富文本)
     *
     * @return goods_content - 商品介绍(富文本)
     */
    public String getGoodsContent() {
        return goodsContent;
    }

    /**
     * 设置商品介绍(富文本)
     *
     * @param goodsContent 商品介绍(富文本)
     */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    /**
     * 获取商品状态(0禁用1启用)
     *
     * @return goods_status - 商品状态(0禁用1启用)
     */
    public Byte getGoodsStatus() {
        return goodsStatus;
    }

    /**
     * 设置商品状态(0禁用1启用)
     *
     * @param goodsStatus 商品状态(0禁用1启用)
     */
    public void setGoodsStatus(Byte goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    /**
     * 获取商品更新时间
     *
     * @return goods_udtime - 商品更新时间
     */
    public Date getGoodsUdtime() {
        return goodsUdtime;
    }

    /**
     * 设置商品更新时间
     *
     * @param goodsUdtime 商品更新时间
     */
    public void setGoodsUdtime(Date goodsUdtime) {
        this.goodsUdtime = goodsUdtime;
    }
}