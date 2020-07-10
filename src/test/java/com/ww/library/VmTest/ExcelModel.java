package com.ww.library.VmTest;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ExcelModel {


    @Excel(name = "姓名")
    private String name;
    @Excel(name = "编号")
    private String num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
