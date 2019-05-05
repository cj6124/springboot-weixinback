package com.wenjie.weixinback.service;

import com.wenjie.weixinback.pojo.Goods;

/**
 * @author chenwenjie
 */
public interface GoodsService {

    /**
     * 添加商品
     * @param picsUrl 轮播图的url
     * @param goods 商品pojo
     */
    public void addGoods(String[] picsUrl, Goods goods);
}
