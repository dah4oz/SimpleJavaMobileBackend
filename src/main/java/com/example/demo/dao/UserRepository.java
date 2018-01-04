package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.User;
import com.example.demo.model.UserAgeStat;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	User findBymId(Long id);
	
	@Query(value = "SELECT new com.example.demo.model.UserAgeStat(u.mAge, count(u)) FROM User u GROUP BY u.mAge")
	public List<UserAgeStat> countUsersByAge();

}
