package com.javaspring.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.dto.UserDTO;
import com.javaspring.service.IUserService;

@RestController(value = "homeControllerOfApi")
public class HomeControllerApi {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/api/user")
	public List<UserDTO> allUser() {
		return userService.findAll();
	}
	
	@PostMapping("/api/user")
	public UserDTO createUser(@RequestBody UserDTO createUser) {
		return userService.save(createUser);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO updateUser) {
		return userService.save(updateUser);
	}
	
	@DeleteMapping("/api/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
