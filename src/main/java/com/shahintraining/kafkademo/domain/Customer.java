package com.shahintraining.kafkademo.domain;

import org.apache.kafka.common.protocol.types.Field;

public record Customer(String username , String email) {
}
