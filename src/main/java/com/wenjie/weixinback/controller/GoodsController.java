package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.common.enums.ResultEnum;
import com.wenjie.weixinback.common.utils.JsonResult;
import com.wenjie.weixinback.common.utils.PagedResult;
import com.wenjie.weixinback.pojo.Goods;
import com.wenjie.weixinback.pojo.Image;
import com.wenjie.weixinback.service.GoodsService;
import com.wenjie.weixinback.service.ImageService;
import com.wenjie.weixinback.vo.GoodsVO;
import com.wenjie.weixinback.vo.LayerImgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenwenjie
 * 操作商品的controller
 */
@Slf4j
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImageService imageService;

    /**
     * 增加商品接口
     * @param goodsVO
     * @return
     */
    @PostMapping("/saveGoods")
    @ResponseBody
    public JsonResult saveGoods(GoodsVO goodsVO){

        //打折价格大于原价则返回信息
        if (null != goodsVO.getGoodsMinprice() && goodsVO.getGoodsMinprice().compareTo(goodsVO.getGoodsOriginalprice()) == 1){
            return JsonResult.errorMsg(ResultEnum.PRICE_ERROR.getMessage());
        }
        //必须填写商品详情
        if (StringUtils.isEmpty(goodsVO.getGoodsContent())){
            return JsonResult.errorMsg(ResultEnum.GOODS_CONTENT.getMessage());
        }

        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsVO, goods);
        //id为空则是增加商品
        if (StringUtils.isEmpty(goodsVO.getGoodsId())) {
            goodsService.addGoods(goodsVO.getPicsUrl(), goods);
        }else {
            goodsService.updataGoods(goodsVO.getPicsUrl(), goods);
        }

        return JsonResult.ok();
    }

    /**
     * 搜索所有商品信息
     * @param page 页数
     * @return 分页信息体
     */
    @RequestMapping("/queryAllGoods")
    @ResponseBody
    public PagedResult queryAllGoods(@RequestParam(defaultValue = "1") Integer page){

        //pageSize可以自定义从前端接收，我为了省事就不搞了
        return goodsService.queryAllGoods(page, 10);
    }

    /**
     * 查询单个商品的所有轮播图
     * @param goodsId 商品id
     * @return layer要求的数据格式
     * @link https://www.layui.com/doc/modules/layer.html
     */
    @ResponseBody
    @RequestMapping("/queryPics")
    public Map<String, Object> queryPics(String goodsId){

        List<Image> images = imageService.queryPicsByGoodsId(goodsId);
        LayerImgVO[] layerImgVOS = new LayerImgVO[images.size()];
        //初始化数组
        for (int i = 0; i < layerImgVOS.length; i++){
            layerImgVOS[i] = new LayerImgVO();
        }
        //填充数据
        for (int i = 0; i < layerImgVOS.length; i++) {
            layerImgVOS[i].setPid(images.get(i).getImageId());
            layerImgVOS[i].setSrc(images.get(i).getImageUrl());
            layerImgVOS[i].setThumb(images.get(i).getImageUrl());
            layerImgVOS[i].setAlt("轮播图");
        }

        Map<String, Object> res = new HashMap<>();
        res.put("title", "商品轮播图");
        res.put("id", 123);
        res.put("start", 0);
        res.put("data", layerImgVOS);

        return res;
    }

    /**
     * 删除商品接口
     * @param goodsId 商品id
     * @return 成功信息
     */
    @ResponseBody
    @PostMapping("/delGoods")
    public JsonResult delGoods(String goodsId){
        goodsService.delGoods(goodsId);
        return JsonResult.ok();
    }

    @ResponseBody
    @RequestMapping("/queryGoodsByParams")
    public PagedResult queryGoodsByParams(Integer page, @RequestParam(defaultValue = "10")Integer pageSize, GoodsVO goodsVO) {

        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsVO, goods);
        return goodsService.queryGoodsByParams(page, pageSize, goods);
    }
}
