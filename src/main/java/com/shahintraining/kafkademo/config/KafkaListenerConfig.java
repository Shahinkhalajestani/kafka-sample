package com.shahintraining.kafkademo.config;

import com.shahintraining.kafkademo.domain.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaListenerConfig {


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Customer> listenerContainerFactory(
            ConsumerFactory<String,Customer> customerKafkaConsumer){
        ConcurrentKafkaListenerContainerFactory<String, Customer> listenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(customerKafkaConsumer);
        return listenerContainerFactory;
    }

}
