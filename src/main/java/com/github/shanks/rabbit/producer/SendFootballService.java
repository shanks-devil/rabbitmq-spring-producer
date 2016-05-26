package com.github.shanks.rabbit.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class SendFootballService extends SendMessageSupport {

	@Value("${sport.exchange}")
	@Getter
	private String exchange;
	
	@Value("${football.routingkey}")
	@Getter
	private String routingKey;
	
}
