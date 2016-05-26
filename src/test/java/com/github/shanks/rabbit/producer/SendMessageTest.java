package com.github.shanks.rabbit.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.shanks.rabbit.msg.MessageModel;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-rabbit.xml")
@Slf4j
public class SendMessageTest {
	
	@Autowired
	@Qualifier(value = "sendMailService")
	private SendMessageService sendMailService;
	
	@Autowired
	@Qualifier(value = "sendBasketballService")
	private SendMessageService sendBasketballService;
	
	@Autowired
	@Qualifier(value = "sendFootballService")
	private SendMessageService sendFootballService;
	
	@Test
	public void sendMail() {
		MessageModel message = new MessageModel();
		String title = "mail";
		log.info("start send {}", title);
		for (int i = 0 ; i< 10 ; i++) {
			message.setMessageId(Long.valueOf(i));
			message.setMessageBody(String.format("[%s]: messageId = %d", title, i));
			sendMailService.sendMessage(message);
			log.info("send {} {}", title, i);
		}
		log.info("end send {}", title);
	}
	
	@Test
	public void sendBasketball() {
		MessageModel message = new MessageModel();
		String title = "Basketball";
		log.info("start send {}", title);
		for (int i = 0 ; i< 10 ; i++) {
			message.setMessageId(Long.valueOf(i));
			message.setMessageBody(String.format("[%s]: messageId = %d", title, i));
			sendBasketballService.sendMessage(message);
			log.info("send {} {}", title, i);
		}
		log.info("end send {}", title);
	}
	
	@Test
	public void sendFootball() {
		MessageModel message = new MessageModel();
		String title = "Football";
		log.info("start send {}", title);
		for (int i = 0 ; i< 10 ; i++) {
			message.setMessageId(Long.valueOf(i));
			message.setMessageBody(String.format("[%s]: messageId = %d", title, i));
			sendFootballService.sendMessage(message);
			log.info("send {} {}", title, i);
		}
		log.info("end send {}", title);
		
	}
	
}
