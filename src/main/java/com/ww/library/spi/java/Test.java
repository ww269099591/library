package com.ww.library.spi.java;

import com.ww.library.spi.Car;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<Car> serviceLoader = ServiceLoader.load(Car.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Car::getBrand);
    }
}
