package com.example.productor.consumer;

import com.example.productor.dto.TransaccionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LogicaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicaConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.transaccion}"})
    public void consumeJsonMessage(TransaccionDTO transaccionDTO){
        LOGGER.info(String.format("Mensaje JSON recivido -> %s", transaccionDTO.toString()));
    }
}