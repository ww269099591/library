package com.ww.library.spi;

public class BM implements Car {


    @Override
    public String getBrand() {
        System.out.println("BM car");
        return "BM";
    }
}

