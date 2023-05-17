package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class AuthController {

	@Autowired
	UserService userService;

	@PostMapping(value = "registeruser", produces = "application/json", consumes = "application/json")
	public UserDTO add(@RequestBody UserDTO userAdd) throws Exception {
		UserDTO addUser = userService.Add(userAdd);
		if (addUser == null) {
			throw new Exception("User is already exist....");
		} else {
			return addUser;
		}
	}

	@PostMapping(value = "login", produces = "application/json", consumes = "application/json")
	public UserDTO loginUser(@RequestBody UserDTO userdto) throws Exception {
		UserDTO login = userService.loginUser(userdto);
		if (login.getUserName() == null) {
			throw new Exception("Wrong UserName or Password..");
		} else {
			return login;
		}
	}

	@GetMapping(value = "getlist", produces = "application/json")
	public List<UserDTO> getList() {
		List<UserDTO> getList = userService.getList();
		return getList;
	}

}
