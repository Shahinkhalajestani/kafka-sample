package com.shahintraining.kafkademo.resource;

import com.shahintraining.kafkademo.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka-trigger")
public record KafkaController(KafkaTemplate<String, Customer> kafkaTemplate) {

    @PostMapping
    public ResponseEntity<Void> triggerKafka(@RequestBody Customer customer){
        kafkaTemplate.send("shahintraining",customer);
        return ResponseEntity.ok().build();
    }

}
