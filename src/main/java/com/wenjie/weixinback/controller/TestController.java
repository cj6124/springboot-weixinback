package com.wenjie.weixinback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenwenjie
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/center")
    public ModelAndView test(){
        return new ModelAndView("center/center");
    }

    @RequestMapping("/addBgm")
    public ModelAndView test1(){
        return new ModelAndView("center/video/addBgm");
    }
}
