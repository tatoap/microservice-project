package com.developer.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.hroauth.entity.User;
import com.developer.hroauth.feignclient.UserFeignClient;

@Service
public class UserService {
	
	public static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User buscarPorEmail(String email) {
		User user = userFeignClient.buscarPorEmail(email).getBody();
		
		if (user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + email);
		return user;
	}
}
