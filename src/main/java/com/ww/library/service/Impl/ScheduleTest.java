package com.ww.library.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("ScheduledTest")
public class ScheduleTest {

    private static Logger log = LoggerFactory.getLogger(ScheduleTest.class);

    String newCron = "*/5 * * * * ?";

    private static String cron;

    private ScheduledFuture<?> future;

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostConstruct
    public void startCron(){
        future=threadPoolTaskScheduler.schedule(new MyRunnable(),new CronTrigger(newCron));
    }


    private class MyRunnable implements Runnable{
        @Override
        public void run() {
              System.out.println("Service1"+System.currentTimeMillis());
        }
    }


}