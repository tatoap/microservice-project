package com.developer.hrworker.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.hrworker.entity.Worker;
import com.developer.hrworker.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> listar() {
		return ResponseEntity.ok(workerRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> buscar(@PathVariable Long id) {
		
		/*try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok(workerRepository.findById(id).get());
	}
}
