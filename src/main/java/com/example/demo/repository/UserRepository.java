package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User getByEmailId(String emailId);

	public User getByEmailIdAndPassword(String emailId,String password);
}
