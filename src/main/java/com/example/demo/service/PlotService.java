package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PlotRepository;
import com.example.demo.model.Plot;
import com.example.demo.model.User;

@Service
@Transactional
public class PlotService {
	
	private static final int PAGE_SIZE = 8;

	private PlotRepository mPlotRepository;

	public PlotService(PlotRepository plotRepository) {
		this.mPlotRepository = plotRepository;
	}
	
	public List<Plot> getPlots() {
		List<Plot> plots = new ArrayList<>();
		mPlotRepository.findAll().forEach(plots::add);
		return plots;
	}
	
	public Page<Plot> getPlotsPart(int pageNum) {
		PageRequest pageRequest = new PageRequest(pageNum - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		return mPlotRepository.findAll(pageRequest);
	}
	
	public void addPlot(Plot plot) {
		mPlotRepository.save(plot);
	}
	
	public void removePlot(Long plotId) {
		mPlotRepository.delete(plotId);
	}
	
	public Plot getPlotById(Long id) {
		return mPlotRepository.findBymId(id);
	}
	
	public void addUserIdToPlot(Long plotId, User user) {
		Plot plot = mPlotRepository.findBymId(plotId);
		plot.setUser(user);
		mPlotRepository.save(plot);
	}
	
}
