package com.github.shanks.rabbit.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.shanks.rabbit.msg.MessageModel;

@Service
public class SendMessage {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	
	public void send(MessageModel messageModel) {
		rabbitTemplate.convertAndSend(messageModel);
	}
}
