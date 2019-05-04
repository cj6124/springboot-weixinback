package com.wenjie.weixinback.service.impl;

import com.wenjie.weixinback.mapper.CategoryMapper;
import com.wenjie.weixinback.pojo.Category;
import com.wenjie.weixinback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author chenwenjie
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class, readOnly = true)
    public List<Category> queryAllCategory() {
        Example categoryExample = new Example(Category.class);
        categoryExample.setOrderByClause("category_udtime DESC");
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        return categories;
    }
}
