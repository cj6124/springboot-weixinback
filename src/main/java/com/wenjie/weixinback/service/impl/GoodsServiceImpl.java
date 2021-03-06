package com.wenjie.weixinback.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wenjie.weixinback.common.utils.KeyUtil;
import com.wenjie.weixinback.common.utils.PagedResult;
import com.wenjie.weixinback.mapper.CategoryMapper;
import com.wenjie.weixinback.mapper.GoodsMapper;
import com.wenjie.weixinback.mapper.ImageMapper;
import com.wenjie.weixinback.pojo.Category;
import com.wenjie.weixinback.pojo.Goods;
import com.wenjie.weixinback.pojo.Image;
import com.wenjie.weixinback.service.GoodsService;
import com.wenjie.weixinback.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenwenjie
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CategoryMapper categoryMapper;

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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public PagedResult queryAllGoods(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Goods> goods = goodsMapper.selectAll();
        //这里不要设置成GoodsVO，不然只会返回一页内容
        PageInfo<Goods> pageList = new PageInfo<>(goods);
        //类型转换
        List<GoodsVO> goodsVOS = goods.stream().map(e -> {
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(e, goodsVO);
            //查询该商品分类对应的名字
            Category category = categoryMapper.selectByPrimaryKey(goodsVO.getCategoryId());
            if (category.getCategoryStatus() == 0){
                goodsVO.setCategoryName(category.getCategoryName() + "(已禁用)");
            }else {
                goodsVO.setCategoryName(category.getCategoryName());
            }
            return goodsVO;
        }).collect(Collectors.toList());

        //设置返回体

        PagedResult result = new PagedResult();
        result.setTotal(pageList.getPages());
        result.setRows(goodsVOS);
        result.setPage(page);
        result.setRecords(pageList.getTotal());

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Goods selectOneGoodsById(String goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updataGoods(String[] picsUrl, Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
        //将商品原来的轮播图删除再重新插入  ----  可以实现动态更新，但是阅读性会很差，所以选择这种处理方式，可用image_id实现
        Example picsExample = new Example(Image.class);
        Criteria criteria = picsExample.createCriteria();
        criteria.andEqualTo("goodsId", goods.getGoodsId());
        imageMapper.deleteByExample(picsExample);
        //重新插入轮播图
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delGoods(String goodsId) {
        //删除商品
        goodsMapper.deleteByPrimaryKey(goodsId);
        //删除商品的轮播图
        Example imageExample = new Example(Image.class);
        Criteria criteria = imageExample.createCriteria();
        criteria.andEqualTo("goodsId", goodsId);
        imageMapper.deleteByExample(imageExample);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public PagedResult queryGoodsByParams(Integer page, Integer pageSize, Goods goods) {
        PageHelper.startPage(page, pageSize);
        Example goodsExample = new Example(Goods.class);
        Criteria criteria = goodsExample.createCriteria();
        if (!"all".equals(goods.getCategoryId())){
            criteria.andEqualTo("categoryId", goods.getCategoryId());
        }
        criteria.andLike("goodsName","%" + goods.getGoodsName() + "%");

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);

        //类型转换
        List<GoodsVO> goodsVOS = goodsList.stream().map(e -> {
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(e, goodsVO);
            //查询该商品分类对应的名字
            Category category = categoryMapper.selectByPrimaryKey(goodsVO.getCategoryId());
            if (category.getCategoryStatus() == 0){
                goodsVO.setCategoryName(category.getCategoryName() + "(已禁用)");
            }else {
                goodsVO.setCategoryName(category.getCategoryName());
            }
            return goodsVO;
        }).collect(Collectors.toList());

        PagedResult grid = new PagedResult();
        grid.setTotal(goodsPageInfo.getPages());
        grid.setRows(goodsVOS);
        grid.setPage(page);
        grid.setRecords(goodsPageInfo.getTotal());

        return grid;
    }
}
