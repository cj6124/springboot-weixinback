package com.wenjie.weixinback.service;

import com.wenjie.weixinback.pojo.Category;

import java.util.List;

/**
 * 商品分类业务
 * @author chenwenjie
 */
public interface CategoryService {
    /**
     * 查询所有分类
     * @return List<Category>
     */
    public List<Category> queryAllCategory();
}
