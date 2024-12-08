package com.example.demo.steps;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@MessageEndpoint
public class TransformerEndpoint {
	
	@Autowired
	private MessageChannel outputChannel;
	
	@ServiceActivator(inputChannel = "inputChannel")
	public void encodeToUTF_8(String message)
	{ 
		
		byte[] encodedBytes = message.getBytes();
		String utf8Message = new String(encodedBytes,StandardCharsets.UTF_8);
		
		Message<String> transformedMessage = MessageBuilder.withPayload(utf8Message).build();
		outputChannel.send(transformedMessage);
	}
	
}
