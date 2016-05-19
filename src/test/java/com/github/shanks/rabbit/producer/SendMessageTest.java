package com.github.shanks.rabbit.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.shanks.rabbit.msg.MessageModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-rabbit.xml")
public class SendMessageTest {

	@Autowired
	private SendMessage sendMessage;
	
	@Test
	public void send() {
		MessageModel message = new MessageModel();
		for (int i = 0 ; i< 10 ; i++) {
			message.setMessageId(Long.valueOf(i));
			message.setMessageBody("i am a messsage id = " + i);
			sendMessage.send(message);
		}
		
	}
}
