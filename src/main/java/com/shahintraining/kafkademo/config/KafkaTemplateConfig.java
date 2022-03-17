package com.shahintraining.kafkademo.config;

import com.shahintraining.kafkademo.domain.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaTemplateConfig {

    @Bean
    public KafkaTemplate<String, Customer> kafkaTemplate(ProducerFactory<String,Customer> customerProducerFactory){
        return new KafkaTemplate<>(customerProducerFactory);
    }

}
