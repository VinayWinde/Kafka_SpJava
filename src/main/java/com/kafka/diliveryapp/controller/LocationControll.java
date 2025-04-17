package com.kafka.diliveryapp.controller;

import com.kafka.diliveryapp.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationControll {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping ("/update")
    public ResponseEntity<?> updateLocation(){
        for (int i = 0; i < 100000; i++) {
            kafkaService.updateLocation("Location: "+ Math.round(Math.random() *100));
        }

        return new ResponseEntity<>(Map.of("[message] :","$LOCATION UPDATED$"), HttpStatus.OK);
    }

}
