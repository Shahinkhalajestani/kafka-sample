package com.shahintraining.kafkademo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahintraining.kafkademo.domain.Customer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

@Component
public class CustomerSerializer implements Serializer<Customer> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Customer customer) {
        if (customer == null) return new byte[0];
        try {
           return mapper.writeValueAsBytes(customer);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}
