package io.rtr.conduit.amqp.impl;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AMQPConnectionPropertiesTest {
    @Test
    public void testValidateBuilder() {
        AMQPConnectionProperties properties = AMQPConnectionProperties.builder()
                .username("Anna")
                .password("Anna's password")
                .automaticRecoveryEnabled(true)
                .connectionTimeout(Duration.ofHours(8))
                .heartbeatInterval(Duration.ofSeconds(2))
                .virtualHost("Anna's vhost")
                .build();

        assertEquals("Anna", properties.getUsername());
        assertEquals("Anna's password", properties.getPassword());
        assertEquals("Anna's vhost", properties.getVirtualHost());
        assertEquals(Duration.ofHours(8).toMillis(), properties.getConnectionTimeout());
        assertEquals(2, properties.getHeartbeatInterval());
    }
}