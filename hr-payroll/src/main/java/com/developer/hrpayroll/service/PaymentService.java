package com.developer.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.hrpayroll.entity.Payment;
import com.developer.hrpayroll.entity.Worker;
import com.developer.hrpayroll.feignclient.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = workerFeignClient.buscar(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
	
	/*@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
						
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}*/

}
