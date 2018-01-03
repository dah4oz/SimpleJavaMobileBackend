package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GroupRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Group;
import com.example.demo.model.Plot;
import com.example.demo.model.User;
import com.example.demo.model.UserAgeStat;

@Service
@Transactional
public class UserService {
	
	private static final int PAGE_SIZE = 8;
	
	private UserRepository mUserRepository;

	public UserService(UserRepository userRepository) {
		this.mUserRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		mUserRepository.findAll().forEach(users::add);
		return users;
	}
	
	public Page<User> getUsers(int pageNum) {
		PageRequest pageRequest = new PageRequest(pageNum - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		return mUserRepository.findAll(pageRequest);
	}
	
	public List<UserAgeStat> getUserCountByAge() {
		return mUserRepository.countUsersByAge();
	}
	
	public void addUser(User user) {
		mUserRepository.save(user);
	}
	
	public void deleteUSer(long userId) {
		mUserRepository.delete(userId);
	}
	
	public User addGroupToUser(Long userId, Group group) {
		User user = mUserRepository.findBymId(userId);
		user.addGroup(group);
		User updatedUser = mUserRepository.save(user);
		
		return updatedUser;
	}
	
	public User removeGroupFromUser(Long userId, Group group) {
		User user = mUserRepository.findBymId(userId);
		user.removeGroup(group);
		User updatedUser = mUserRepository.save(user);
		
		return updatedUser;
	}
	
	public User addPlotToUser(Long userId, Plot plot) {
		User user = mUserRepository.findBymId(userId);
		user.addPlot(plot);
		User updatedUser = mUserRepository.save(user);
		
		return updatedUser;
	}
	
	public User removePlotFromUser(Long userId, Plot plot) {
		User user = mUserRepository.findBymId(userId);
		user.removePlot(plot);
		User updatedUser = mUserRepository.save(user);
		
		return updatedUser;
	}

}
