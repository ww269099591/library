package com.ww.library.controller;

import com.ww.library.entity.Warning;
import com.ww.library.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class WarningController {
    //根据预警的级别来查询数据
    @Autowired
    WarningService warningService;
    /**
     * 根据等级分类
     * @param param()
     * @return
     */
    @RequestMapping("distinctBylevel")
    public Map<String,Object> distinctBylevel(Map<String,Object> param){
        return warningService.distinctBylevel(param);
    }

    /**
     * 根据时间分类
     * @param param()
     * @return
     */
    @RequestMapping("distinctByTime")
    public Map<String,Object> distinctByTime(Map<String,Object> param){
        return warningService.distinctByTime(param);
    }

    /**
     * 列出所有
     * @param param()
     * @return
     */
    @RequestMapping("listAll")
    public Map<String,Object> listAll(Map<String,Object> param){
        return warningService.listAll(param);
    }

    /**
     * 新增预警
     * @param
     * @return
     */
    @RequestMapping("addWarning")
    public Map<String,Object> addWarning(Warning warning){
        return warningService.addWarning(warning);
    }
}
