package com.github.shanks.rabbit.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class SendBasketballService extends SendMessageSupport {

	@Value("${sport.exchange}")
	@Getter
	private String exchange;

	@Value("${basketball.routingkey}")
	@Getter
	private String routingKey;
	
}
