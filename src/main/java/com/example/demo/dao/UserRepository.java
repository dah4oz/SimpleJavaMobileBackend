package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.User;
import com.example.demo.model.UserAgeStat;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	User findBymId(Long id);
	
	@Query(value = "SELECT COUNT(u) as counter, u.age FROM user u GROUP BY u.age")
	public List<UserAgeStat> countUsersByAge();

}
