package com.ww.library.VmTest;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelTest {
    @Test
    public  void aaa() {


        List<ExcelModel> deptExcels = new ArrayList<>();
        ExcelModel deptExcel = new ExcelModel();
        deptExcel.setName("技术一部");
        deptExcel.setNum("技术一部");
        deptExcels.add(deptExcel);
        deptExcels.add(deptExcel);

        // 创建参数对象
        ExportParams exportParams1 = new ExportParams();
        // 设置sheet得名称
        exportParams1.setSheetName("部门人员信息");

        // 创建sheet1使用得map
        Map<String, Object> deptDataMap = new HashMap<>(4);
        // title的参数为ExportParams类型
        deptDataMap.put("title", exportParams1);
        // 模版导出对应得实体类型
        deptDataMap.put("entity", ExcelModel.class);
        // sheet中要填充得数据
        deptDataMap.put("data", deptExcels);

        // 将sheet1和sheet2使用得map进行包装
        List<Map<String, Object>> sheetsList = new ArrayList<>();
        sheetsList.add(deptDataMap);
        // 执行方法
        Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
    }




    @Test
    public  void exportExcel() {
        ArrayList<ExcelModel> rawList = new ArrayList<>();

        int num = 4;
        for (int i = 0; i < num ; i++) {
            ExcelModel excelModel = new ExcelModel();
            excelModel.setName("admin"+i);
            excelModel.setNum(String.valueOf(i));
            rawList.add(excelModel);
        }

        List<List<ExcelModel>> list = new ArrayList<>();
        List<ExcelModel>  objects = rawList.subList(0,2);
        list.add(objects);

        defaultExport(list);
    }

    private static void defaultExport(List<List<ExcelModel>> list) {

        List<Map<String, Object>> sheetsList = new ArrayList<>();
        for(int i=0;i<1;i++) {
            ExportParams exportParams = new ExportParams();
            //exportParams.setSheetName("部门人员信息");
            Map<String, Object> hashMap = new HashMap<>(4);
            hashMap.put("title", exportParams);
            hashMap.put("entity", ExcelModel.class);
            hashMap.put("data", list.get(i));
            sheetsList.add(hashMap);
        }

        Workbook sheets = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);

    }


}
