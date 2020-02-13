package com.ww.library.service;

import com.ww.library.entity.Warning;

import java.util.Map;

public interface WarningService {
    Map<String,Object> distinctBylevel(Map<String,Object> param);

    Map<String,Object> distinctByTime(Map<String,Object> param);

    Map<String,Object> listAll(Map<String,Object> param);

    Map<String,Object> addWarning(Warning warning);
}
