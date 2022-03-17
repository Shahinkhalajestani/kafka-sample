package com.shahintraining.kafkademo.resource;

import com.shahintraining.kafkademo.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(id = "customer-listener"
    ,topics = "shahintraining",groupId = "customer",containerFactory = "listenerContainerFactory")
    public void listenToKafka(Customer customer){
        System.out.println("the customer is : "+customer);
    }

}
