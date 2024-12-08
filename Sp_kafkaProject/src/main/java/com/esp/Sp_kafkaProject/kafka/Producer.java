package com.esp.Sp_kafkaProject.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.esp.Sp_kafkaProject.entities.BasketMatch;

@Service
public class Producer {

	
	@Autowired
	private KafkaTemplate<String, BasketMatch> kafkaTemplate;
	
	
	
//	private int converterPartition(String partitionKey)
//	{ 
//		if (partitionKey.equals("Miami Vs Spurs"))
//			return 0;
//		return (partitionKey.equals("Phoenix Vs Lakers") ? 1 : 2);
//	}
	
	public void sendMessage(BasketMatch match) //Envoie d'un record
	{ 
		Message<BasketMatch> message = MessageBuilder.
				withPayload(match).
				setHeader(KafkaHeaders.TOPIC,"Basket_info").
				build();
		
		kafkaTemplate.send(message);
	
	}

}
