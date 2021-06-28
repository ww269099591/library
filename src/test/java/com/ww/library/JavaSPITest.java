package com.ww.library;

import com.ww.library.spi.Car;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Car> serviceLoader = ServiceLoader.load(Car.class);
        serviceLoader.forEach(car -> System.out.println(car.getBrand()));
    }



}
