package com.ww.library.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;


@RestController
@Component
public class DynamicTask {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    public DynamicTask(){
        this.threadPoolTaskScheduler=new ThreadPoolTaskScheduler();
    }

//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        return new ThreadPoolTaskScheduler();
//    }

    @PostConstruct
    public String startCron() {

        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0 18 15 * * ?"));
        System.out.println("DynamicTask.startCron()");
        System.gc();
        return "startCron";

    }

    @RequestMapping("/stopCron")
    public String stopCron() {

        if (future != null) {
            future.cancel(true);
        }
        System.out.println("DynamicTask.stopCron()");
        return "stopCron";
    }

    @RequestMapping("/changeCron10")
    public String startCron10() {

        stopCron();// 先停止，在开启.
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/2 * * * * *"));
        System.out.println("DynamicTask.startCron10()");
        return "changeCron10";
    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("DynamicTask.MyRunnable.run()，" + new Date());
        }
    }
}