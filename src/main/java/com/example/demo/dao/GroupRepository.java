package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Group;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

}
