package com.developer.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
