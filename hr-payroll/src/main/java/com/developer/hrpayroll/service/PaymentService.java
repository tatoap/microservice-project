package com.developer.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.developer.hrpayroll.entity.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
