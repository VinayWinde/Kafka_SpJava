package com.kafka.diliveryapp.service;

import com.kafka.diliveryapp.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaService {

    private Logger logger= LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemp;

    public boolean updateLocation(String location){
        this.kafkaTemp.send(AppConstants.LOCATION_TOPIC_NAME,location);
        this.logger.info("$$$$$$-LOCATION PRODUCED-$$$$$$");
        return true;
    }

}
