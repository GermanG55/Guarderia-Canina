package com.example.demo.infrastructura.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class NotifyServiceResource {
    private RabbitTemplate rabbitTemplate;

    public NotifyServiceResource(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendNotification(String notification){
        rabbitTemplate.convertAndSend("notificationQueue","notificacion",notification);

    }
}
