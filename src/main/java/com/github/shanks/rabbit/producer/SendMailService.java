package com.github.shanks.rabbit.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class SendMailService extends SendMessageSupport {

//	@Value("${mail.exchange}")
//	@Getter
//	private String exchange;
	
	@Getter
	@Value("${mail.routingKey}")
	private String routingKey;
	
}
