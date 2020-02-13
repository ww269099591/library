package com.ww.library.dao;

import com.ww.library.entity.Warning;

import java.util.List;
import java.util.Map;

public interface WarningMapper {
    List<Map<String,Object>> distinctBylevel(Map<String,Object> param);
    List<Map<String,Object>>distinctByTime(Map<String,Object> param);
    List<Warning> listAll(Map<String,Object> param);
    Map<String,Object> addWarning(Warning warning);
}
