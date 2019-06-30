package com.ww.library.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "SuccessMq")
@Component
public class Reiceiver {

    @RabbitHandler
    public void receive(String in) throws InterruptedException {

        System.out.println("instance " + " [x] Received '" + in + "'");

    }}
