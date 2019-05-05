package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.pojo.Category;
import com.wenjie.weixinback.pojo.Goods;
import com.wenjie.weixinback.pojo.Image;
import com.wenjie.weixinback.service.CategoryService;
import com.wenjie.weixinback.service.GoodsService;
import com.wenjie.weixinback.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenwenjie
 * 返回各种视图的Controller
 */
@Controller
@RequestMapping("/back")
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImageService imageService;

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
    public String saveGoods(String goodsId, ModelMap result){
        List<Category> categories = categoryService.queryAllCategory();
        result.put("categories",categories);
        //如果不为空，则添加商品的相关信息返回
        if (!StringUtils.isEmpty(goodsId)){
            //获取数据
            Goods goods = goodsService.selectOneGoodsById(goodsId);
            List<Image> pics = imageService.queryPicsByGoodsId(goodsId);

            //填充数据
            result.put("goods", goods);
            result.put("pics", pics);
        }
        return "center/goods/saveGoods";
    }

    /**
     * 返回商品列表的视图
     * @return ModelAndView
     */
    @RequestMapping("/goodsListPage")
    public ModelAndView goodListPage(){
        return new ModelAndView("center/goods/goodsList");
    }
}
