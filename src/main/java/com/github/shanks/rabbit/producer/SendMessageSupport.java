package com.github.shanks.rabbit.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.shanks.rabbit.msg.MessageModel;

@Component
public abstract class SendMessageSupport implements SendMessageService {

	@Autowired
	protected AmqpTemplate rabbitTemplate;

	public void sendMessage(MessageModel message) {
		rabbitTemplate.convertAndSend(getExchange(), getRoutingKey(), message);
	}

	//default exchange
	public String getExchange() {
		return "";
	}
	
}
