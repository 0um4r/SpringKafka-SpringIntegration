package com.example.demo.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

@Component
@MessageEndpoint
public class EnricherEndpoint{

	@Autowired
	private MessageChannel finalOutputChannel;
	
	@ServiceActivator(inputChannel = "outputChannel")
	public void newState(String message)
	{ 
		String header  = "23050KEY_VALUE_CODE";
		String signature = "33XXFG__*FSGSSI[]983BVXFFFFF";
		
		StringBuilder macon = new StringBuilder();
		macon.append("{Content:" + message + ",");
		macon.append("\nHeader : " + header  + ",");
		macon.append("\nsignature-key:" + signature +",");
		macon.append("\nAlgo: LuiKang_redBalls" + "}");
		
		Message<String> tokenizedMessage =  MessageBuilder.withPayload(macon.toString()).build();
		finalOutputChannel.send(tokenizedMessage);
	
	}

}
