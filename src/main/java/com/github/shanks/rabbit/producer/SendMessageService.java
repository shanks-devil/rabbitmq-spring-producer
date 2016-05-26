package com.github.shanks.rabbit.producer;

import com.github.shanks.rabbit.msg.MessageModel;

public interface SendMessageService {

	void sendMessage(MessageModel message);

	String getExchange();

	String getRoutingKey();
}
