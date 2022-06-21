package com.practice.haoyuan.kafka.controllers;

import com.practice.haoyuan.kafka.services.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "kafka")
public class KafkaController {

    @Autowired
    private KafKaProducerService producerService;

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessageToKafka(@RequestBody String requestBody){
        try{
            producerService.sendMessage(requestBody);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
