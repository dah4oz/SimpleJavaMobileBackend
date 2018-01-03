package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Group;
import com.example.demo.service.GroupService;

@RestController
@RequestMapping(value = "/group")
public class GroupController {

	private GroupService mGroupService;

	public GroupController(GroupService groupService) {
		this.mGroupService = groupService;
	}
	
	@RequestMapping
	public List<Group> getUsers() {
		return mGroupService.getGroups();
	}
	
	@RequestMapping(value = "/part/{page}")
	public List<Group> getUserPage(@PathVariable Integer pageNumber) {
		Page<Group> groupPage = mGroupService.getGroupsPart(pageNumber);
		return groupPage.getContent();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addGroup(@RequestBody Group group) {
		mGroupService.addGroup(group);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> removeGroup(@RequestParam("groupId") String groupId) {
		mGroupService.deleteGroup(Long.valueOf(groupId));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
