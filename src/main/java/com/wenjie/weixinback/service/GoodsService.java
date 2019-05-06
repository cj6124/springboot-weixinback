package com.wenjie.weixinback.service;

import com.wenjie.weixinback.common.utils.PagedResult;
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

    /**
     * 查询商品列表
     * @param page 查询第几页
     * @param pageSize 页面大小
     * @return
     */
    public PagedResult queryAllGoods(Integer page, Integer pageSize);

    /**
     * 查询单个商品
     * @param goodsId 商品id
     * @return 商品的pojo
     */
    public Goods selectOneGoodsById(String goodsId);

    /**
     * 更新商品
     * @param picsUrl 轮播图的url
     * @param goods 商品pojo
     */
    public void updataGoods(String[] picsUrl, Goods goods);
}
