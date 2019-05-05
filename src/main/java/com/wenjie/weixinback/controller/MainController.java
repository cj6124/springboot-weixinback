package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.pojo.Category;
import com.wenjie.weixinback.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chenwenjie
 * 返回各种视图的Controller
 */
@Controller
@RequestMapping("/back")
public class MainController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 返回主页面视图
     * @return ModelAndView
     */
    @RequestMapping("/center")
    public ModelAndView center(){
        return new ModelAndView("center/center");
    }

    /**
     * 返回保存商品页面的视图
     * @return ModelAndView
     */
    @RequestMapping("/saveGoodsPage")
    public ModelAndView saveGoods(){
        List<Category> categories = categoryService.queryAllCategory();

        return new ModelAndView("center/goods/saveGoods", "categories", categories);
    }

    @RequestMapping("/goodsListPage")
    public ModelAndView goodListPage(){
        return new ModelAndView("center/goods/goodsList");
    }
}
