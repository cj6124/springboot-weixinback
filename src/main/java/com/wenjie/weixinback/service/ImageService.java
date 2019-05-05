package com.wenjie.weixinback.service;

import com.wenjie.weixinback.pojo.Image;

import java.util.List;

public interface ImageService {

    /**
     * 查询单个商品的轮播图
     * @param goodsId 商品id
     * @return 图片url数组
     */
    public List<Image> queryPicsByGoodsId(String goodsId);
}
