package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
@MessageEndpoint
public class ProducerService {

    @Autowired
    private MessageChannel inputChannel; 

    public void sendMessage(String messageContent) {
        Message<String> message = MessageBuilder.withPayload(messageContent).build();
        inputChannel.send(message);
    }
}

