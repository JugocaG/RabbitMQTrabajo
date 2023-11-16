package com.example.productor.publisher;

import com.example.productor.dto.TransaccionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogicaProducer {

    @Value("${rabbitmq.exchange.transaccion}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicaProducer.class);

    private RabbitTemplate rabbitTemplate;

    public LogicaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(TransaccionDTO transaccionDTO){
        LOGGER.info(String.format("Json message sent -> %s", transaccionDTO.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, transaccionDTO);
    }

}