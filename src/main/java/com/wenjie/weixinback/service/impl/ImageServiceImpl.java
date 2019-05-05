package com.wenjie.weixinback.service.impl;

import com.wenjie.weixinback.mapper.ImageMapper;
import com.wenjie.weixinback.pojo.Image;
import com.wenjie.weixinback.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

/**
 * @author chenwenjie
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Image> queryPicsByGoodsId(String goodsId) {
        Example imageExample = new Example(Image.class);
        Criteria criteria = imageExample.createCriteria();
        criteria.andEqualTo("goodsId", goodsId);
        List<Image> images = imageMapper.selectByExample(imageExample);
        return images;
    }
}
