package com.wenjie.weixinback.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chenwenjie
 */
@Data
public class Goods implements Serializable {
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
     * 商品库存
     */
    @Column(name = "goods_stock")
    private Integer goodsStock;

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
    private Integer goodsStatus;

    /**
     * 商品是否热门(0不是，1是)
     */
    @Column(name = "goods_ishot")
    private Integer goodsIsHot;

    /**
     * 商品更新时间
     */
    @Column(name = "goods_udtime")
    private Date goodsUdtime;

}