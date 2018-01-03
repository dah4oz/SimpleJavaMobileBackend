package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Plot;
import com.example.demo.model.User;

public interface PlotRepository extends PagingAndSortingRepository<Plot, Long> {

	
	Plot findBymId(Long id);
}
