package org.example.rabbitmq.demo.msg;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = {"TestDirectQueue"})
public class DirectReceiver {



    @RabbitHandler
    public void handlerMsg(Map testMsg){
        System.out.println("消费者收到direct消息： "+testMsg.toString());

    }


}
