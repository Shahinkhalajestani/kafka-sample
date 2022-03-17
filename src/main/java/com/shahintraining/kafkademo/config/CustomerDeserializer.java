package com.shahintraining.kafkademo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahintraining.kafkademo.domain.Customer;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomerDeserializer implements Deserializer<Customer> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Customer deserialize(String s, byte[] bytes) {
        if (bytes.length==0) return null;
        try {
           return mapper.readValue(bytes,Customer.class);
        } catch (IOException e) {
            throw new DeserializationException(e.getMessage(),bytes,false,e);
        }
    }
}
