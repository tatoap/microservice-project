package com.developer.hrworker.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.hrworker.entity.Worker;
import com.developer.hrworker.repository.WorkerRepository;@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> listar() {
		return ResponseEntity.ok(workerRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(workerRepository.findById(id).get());
	}
}
