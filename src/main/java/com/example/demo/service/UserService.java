package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;

public interface UserService {

	UserDTO Add(UserDTO userAdd);

	UserDTO loginUser(UserDTO userLogin);
	
	List<UserDTO> getList();

	void deleteById(long id);
}
