package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.GroupRepository;
import com.example.demo.model.Group;

@Service
public class GroupService {

	private GroupRepository mGroupRepository;

	public GroupService(GroupRepository groupRepository) {
		this.mGroupRepository = groupRepository;
	}
	
	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<>();
		mGroupRepository.findAll().forEach(groups::add);
		return groups;
	}
	
	public void addGroup(Group group) {
		System.out.println("Group name = " + group.getName());
		mGroupRepository.save(group);
	}
	
	public void deleteGroup(Long groupId) {
		mGroupRepository.delete(groupId);
	}
	
	public Group getGroupById(Long id) {
		return mGroupRepository.findBymId(id);
	}
	
}
