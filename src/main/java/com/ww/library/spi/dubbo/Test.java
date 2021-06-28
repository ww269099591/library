package com.ww.library.spi.dubbo;

import com.ww.library.spi.Car;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class Test {

    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader =
                ExtensionLoader.getExtensionLoader(Car.class);
        Car optimusPrime = extensionLoader.getExtension("Benz");
        optimusPrime.getBrand();
        Car bumblebee = extensionLoader.getExtension("BM");
        bumblebee.getBrand();
    }
}
