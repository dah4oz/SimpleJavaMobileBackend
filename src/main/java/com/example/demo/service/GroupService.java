package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GroupRepository;
import com.example.demo.model.Group;
import com.example.demo.model.Plot;

@Service
public class GroupService {
	
	private static final int PAGE_SIZE = 8;

	private GroupRepository mGroupRepository;

	public GroupService(GroupRepository groupRepository) {
		this.mGroupRepository = groupRepository;
	}
	
	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<>();
		mGroupRepository.findAll().forEach(groups::add);
		return groups;
	}
	
	public Page<Group> getGroupsPart(int pageNum) {
		PageRequest pageRequest = new PageRequest(pageNum - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		return mGroupRepository.findAll(pageRequest);
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
