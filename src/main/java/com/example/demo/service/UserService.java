package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {
	
	private UserRepository mUserRepository;

	public UserService(UserRepository mUserRepository) {
		this.mUserRepository = mUserRepository;
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		mUserRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUSer() {
		User user = new User();
		mUserRepository.save(user);
	}
	
	public void deleteUSer(long userId) {
		mUserRepository.delete(userId);
	}

}
