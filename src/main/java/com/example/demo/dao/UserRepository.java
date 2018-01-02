package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	

}
