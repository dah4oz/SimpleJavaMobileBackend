package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Group;
import com.example.demo.model.Plot;
import com.example.demo.model.User;
import com.example.demo.service.GroupService;
import com.example.demo.service.PlotService;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	private UserService mUserService;
	
	private GroupService mGroupService;
	
	private PlotService mPlotService;

	public UserController(UserService userService) {
		this.mUserService = userService;
	}
	
	@Autowired
	public void setGroupService(GroupService service) {
		mGroupService = service;
	}
	
	@Autowired
	public void setPlotService(PlotService service) {
		mPlotService = service;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return mUserService.getAllUsers();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addGroup(@RequestBody User user) {
		mUserService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> removeGroup(@RequestParam("userId") String userId) {
		mUserService.deleteUSer(Long.valueOf(userId));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value = "/{userId}/add/group", method = RequestMethod.POST)
	public ResponseEntity<String> attachGroupToUser(@PathVariable("userId") String userId, 
			@RequestParam("groupId") String groupId) {
		
		Group group = mGroupService.getGroupById(Long.valueOf(groupId));
		if (group != null) {
			mUserService.addGroupToUser(Long.valueOf(userId), group);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	}
	
	@RequestMapping(value = "/{userId}/add/plot", method = RequestMethod.POST)
	public ResponseEntity<String> addPlotToUser(@PathVariable("userId") String userId, 
			@RequestParam("plotId") String plotId) {
		Plot plot = mPlotService.getPlotById(Long.valueOf(plotId));
		
		if(plot != null) {
			mUserService.addPlotToUser(Long.valueOf(userId), plot);
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
