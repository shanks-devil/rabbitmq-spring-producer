package com.github.shanks.rabbit.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.shanks.rabbit.msg.MessageModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SendMessage {

	@Value("${retry.count}")
	private Long retryCount;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(MessageModel messageModel) {
		for (int i = 0; i < retryCount; i++) {
			try {
				rabbitTemplate.convertAndSend(messageModel);
				break;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					log.warn(e.getMessage(), e);
				}
			}
		}
	}
}
