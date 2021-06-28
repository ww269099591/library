package com.ww.library.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Car {

    String getBrand();

}
