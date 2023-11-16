package com.example.productor.controller;


import com.example.productor.dto.TransaccionDTO;
import com.example.productor.publisher.LogicaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonController {

    private LogicaProducer jsonProducer;

    public JsonController(LogicaProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody TransaccionDTO transaccionDTO){
        jsonProducer.sendJsonMessage(transaccionDTO);
        return ResponseEntity.ok("Transaccion enviada a RabbitMQ...");
    }
}