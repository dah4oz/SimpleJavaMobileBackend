package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Group;
import com.example.demo.model.User;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

	Group findBymId(Long id);
}
