package com.inkdrop.config.foursquare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fi.foyt.foursquare.api.FoursquareApi;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FoursquareConfiguration {

	@Value("${foursquare.client}")
	String clientId;
	
	@Value("${foursquare.secret}")
	String clientSecret;
	
	@Bean
	public FoursquareApi newApi(){
		log.info("new Foursquare API with "+clientId+" and "+clientSecret);
		return new FoursquareApi(clientId, clientSecret, null);
	}
}
