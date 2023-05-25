package com.example.demo.service.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@ExtendWith(MockitoExtension.class)
public class NotifyServiceResourceTest {
    @Mock
    private RabbitTemplate rabbitTemplate;

    private NotifyServiceResource notifyServiceResource;
    @Test
    void Given_A_String_When_Send_Notification_Is_Cast_Then_Send_String_To_Rabbit() {
        String notification = "Test Notification";
        notifyServiceResource = new NotifyServiceResource(rabbitTemplate);

        notifyServiceResource.sendNotification(notification);

        Mockito.verify(rabbitTemplate)
                .convertAndSend("notificationQueue", "notificacion", notification);
    }
}
