package com.wenjie.weixinback.service.impl;

import com.wenjie.weixinback.WeixinbackApplication;
import com.wenjie.weixinback.pojo.Category;
import com.wenjie.weixinback.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinbackApplication.class)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void queryAllCategory() {
        List<Category> categories = categoryService.queryAllCategory();
        log.info(String.valueOf(categories));
    }
}