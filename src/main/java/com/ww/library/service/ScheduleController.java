package com.ww.library.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleController {
    @Scheduled(initialDelay = 1000*10,fixedRate = 2*1000)
    public void delay(){
        System.out.println(new Date());
    }
}
