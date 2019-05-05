package com.wenjie.weixinback.service.impl;

import com.wenjie.weixinback.common.utils.KeyUtil;
import com.wenjie.weixinback.mapper.GoodsMapper;
import com.wenjie.weixinback.mapper.ImageMapper;
import com.wenjie.weixinback.pojo.Goods;
import com.wenjie.weixinback.pojo.Image;
import com.wenjie.weixinback.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenwenjie
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addGoods(String[] picsUrl, Goods goods) {
        //生成商品随机id
        String goodsId = KeyUtil.genUniqueKey();
        //插入商品
        goods.setGoodsId(goodsId);
        goodsMapper.insertSelective(goods);

        //插入轮播图
        for (String picurl : picsUrl) {
            //生成图片随机id
            String imageId = KeyUtil.genUniqueKey();
            Image image = new Image();
            image.setImageId(imageId);
            image.setGoodsId(goods.getGoodsId());
            image.setImageUrl(picurl);
            imageMapper.insertSelective(image);
        }
    }
}
