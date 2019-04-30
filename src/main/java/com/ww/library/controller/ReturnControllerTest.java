package com.ww.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("ReturnControllerTest")
public class ReturnControllerTest {
    /**
     * 返回modelandview不绑定在response中
     */
    @RequestMapping("ModelAndViewTest")
    public ModelAndView ModelAndViewTest(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    /**
     * 返回modelandview绑定在response中
     */
    @RequestMapping("ModelAndViewTest1")
    @ResponseBody
    public ModelAndView ModelAndViewTest1(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    /**
     * 返回modelandview不绑定在response中
     */
    /**
     * 返回modelandview不绑定在response中
     */
    /**
     * 返回modelandview不绑定在response中
     */
    /**
     * 返回modelandview不绑定在response中
     */
    /**
     * 返回modelandview不绑定在response中
     */
}
