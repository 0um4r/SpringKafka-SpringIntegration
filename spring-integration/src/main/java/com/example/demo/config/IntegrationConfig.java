package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;



@Configuration
public class IntegrationConfig {
	
	

    @Bean
    MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    MessageChannel outputChannel() {
        return new DirectChannel();
    }
    
    @Bean
    MessageChannel finalOutputChannel()
    { 
    	return new DirectChannel();
    }
 
//  
//    @Bean
//    IntegrationFlow transformData() {
//        return IntegrationFlow.from("inputChannel")
//                .transform(new TransformerEndpoint()::capitalise)
//                .channel("outputChannel")
//                .get();
//    }
//    
//    @Bean
//    IntegrationFlow enrichData()
//    {
//    	return IntegrationFlow.from("outputChannel")
//    			.transform(new EnricherEndpoint()::newState)
//    			.channel("finalOutputChannel")
//    			.get();
//    }
}

