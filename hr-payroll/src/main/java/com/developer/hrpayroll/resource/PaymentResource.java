package com.developer.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.hrpayroll.entity.Payment;
import com.developer.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "pagamentoAlternativo")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> pagamento(@PathVariable Long workerId, @PathVariable Integer days){
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> pagamentoAlternativo(Long workerId, Integer days){
		return ResponseEntity.ok(new Payment("Brann", 400.0, days));
	}
}
