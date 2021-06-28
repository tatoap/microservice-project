package com.developer.hruser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.hruser.entity.User;
import com.developer.hruser.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> buscar(@PathVariable Long userId){
		return ResponseEntity.ok(userRepository.findById(userId).get());
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> buscarPorEmail(@RequestParam String email){
		return ResponseEntity.ok(userRepository.findByEmail(email));
	}
}
