package com.wenjie.weixinback.controller;

import com.wenjie.weixinback.common.enums.ResultEnum;
import com.wenjie.weixinback.common.utils.JsonResult;
import com.wenjie.weixinback.pojo.Goods;
import com.wenjie.weixinback.service.GoodsService;
import com.wenjie.weixinback.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenwenjie
 */
@Slf4j
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    @ResponseBody
    public JsonResult addGoods(GoodsVO goodsVO){

        //打折价格大于原价则返回信息
        if (null != goodsVO.getGoodsMinprice() && goodsVO.getGoodsMinprice().compareTo(goodsVO.getGoodsOriginalprice()) == 1){
            return JsonResult.errorMsg(ResultEnum.PRICE_ERROR.getMessage());
        }

        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsVO, goods);
        goodsService.addGoods(goodsVO.getPicsUrl(), goods);

        return JsonResult.ok();
    }

}
