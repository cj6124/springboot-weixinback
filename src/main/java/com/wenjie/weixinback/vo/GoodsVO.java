package com.wenjie.weixinback.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chenwenjie
 */
@Data
public class GoodsVO implements Serializable {

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品所属分类id
     */
    private String categoryId;

    /**
     * 商品所属分类名字
     */
    private String categoryName;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品视频url
     */
    private String goodsVideourl;

    /**
     * 商品封面
     */
    private String goodsPicurl;

    /**
     * 商品原价(之后在精选页面才会显示原价)
     */
    private BigDecimal goodsOriginalprice;

    /**
     * 商品折扣价
     */
    private BigDecimal goodsMinprice;

    /**
     * 商品库存
     */
    private Integer goodsStock;

    /**
     * 商品简述(只有在精选页面才显示)
     */
    private String goodsCharacteristic;

    /**
     * 商品介绍(富文本)
     */
    private String goodsContent;

    /**
     * 商品状态(0禁用1启用)
     */
    private Integer goodsStatus;

    /**
     * 商品是否热门(0不是，1是)
     */
    private Integer goodsIsHot;

    /**
     * 商品更新时间
     */
    private Date goodsUdtime;

    /**
     * 上面是和pojo对应的部分字段
     * 下面这些是额外接收前端的
     */

    /**
     * 轮播图的url数组
     */
    private String[] picsUrl;

}
