package com.ww.library.service.Impl;

import com.ww.library.dao.WarningMapper;
import com.ww.library.entity.Warning;
import com.ww.library.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WarningServiceImpl implements WarningService {
    @Autowired
    WarningMapper warningMapper;

    final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Map<String, Object> distinctBylevel(Map<String, Object> param) {
        Map<String,Object> result=new HashMap<>();
        param.put("startTime",getOneMonthAgo());
        param.put("endTime",getNow());
        try {
            result.put("distribution",warningMapper.distinctBylevel(param));
        }catch (Exception e){
            result.put("result",false);
            result.put("message","查询数据库失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> distinctByTime(Map<String, Object> param) {
        Map<String,Object> result=new HashMap<>();
        param.put("startTime",getOneMonthAgo());
        param.put("endTime",getNow());
        try {
            result.put("distribution",warningMapper.distinctByTime(param));
        }catch (Exception e){
            result.put("result",false);
            result.put("message","查询数据库失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> listAll(Map<String, Object> param) {
        Map<String,Object> result=new HashMap<>();
        try {
            result.put("list",warningMapper.listAll(param));
        }catch (Exception e){
            e.printStackTrace();
            result.put("result",false);
            result.put("message","查询数据库失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> addWarning(Warning warning) {
        return warningMapper.addWarning(warning);
    }


    public String getNow(){
        return df.format(new Date());// new Date()为获取当前系统时间
    }
    public String getOneMonthAgo(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return df.format(m);
    }

}
