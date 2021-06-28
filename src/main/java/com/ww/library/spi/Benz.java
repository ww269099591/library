package com.ww.library.spi;

public class Benz implements Car {
    @Override
    public String getBrand() {
        System.out.println("benz car");
        return "Benz";
    }
}