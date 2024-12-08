package com.example.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
@MessageEndpoint
public class ConsumerService {

    @ServiceActivator(inputChannel ="finalOutputChannel")
    public void handleMessage(String message) {
        // Process the message
        System.out.println("Received message: " + "\n"+ message);
    }
}
