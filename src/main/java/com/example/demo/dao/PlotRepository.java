package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Plot;

public interface PlotRepository extends PagingAndSortingRepository<Plot, Long> {

}
