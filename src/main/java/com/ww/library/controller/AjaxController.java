package com.ww.library.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Ajax")
public class AjaxController {
    private String Wangwei="wangwei";

    @RequestMapping("ToAjaxTest")
    public String ToAjaxTest() {
        return "ajaxTest";
    }

    /**
     * 试验ajax返回modelandview 不绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("modelAndViewTest")
    public ModelAndView modelAndViewTest() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", "success");
        return mv;
    }
    /**
     * 试验ajax返回modelandview 并且绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("modelAndViewTest2")
    @ResponseBody
    public ModelAndView modelAndViewTest2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", "success");
        return mv;
    }

    /**
     * 试验ajax返回Map<String,Object> 不绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("mapTest")
    public Map<String,Object> mapTest() {
        Map<String,Object> map=new HashMap<>();
        map.put("result","success");
        return map;
    }

    /**
     * 试验ajax返回Map<String,Object>并且绑定到responsebody中
     * 结果：返回数据成功
     */
    @RequestMapping("mapTest2")
    @ResponseBody
    public Map<String,Object> mapTest2() {
        Map<String,Object> map=new HashMap<>();
        map.put("result","success");
        return map;
    }

    /**
     * 试验ajax返回String,不绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("stringTest")
    public String stringTest() {
        Map<String,Object> map=new HashMap<>();
        map.put("result","success");
        return JSON.toJSONString(map);
    }

    /**
     * 试验ajax返回String，并且绑定到responsebody中
     * 结果：跳出，但是返回的结果为undefined,当ajax请求加上 dataType:"json",后显示成功
     */
    @RequestMapping("stringTest2")
    @ResponseBody
    public String stringTest2() {
        Map<String,Object> map=new HashMap<>();
        map.put("result","success");
        return JSON.toJSONString(map);
    }
    /**
     * 试验ajax返回Model,不绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("modelTest")
    public Model modelTest(Model model) {
        model.addAttribute("result","success");
        return model;
    }
    /**
     * 试验ajax返回Model,绑定到responsebody中
     * 结果：返回数据失败
     */
    @RequestMapping("modelTest2")
    @ResponseBody
    public Model modelTest2(Model model) {
        model.addAttribute("result","success");
        return model;
    }

}
