package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PlotRepository;
import com.example.demo.model.Plot;

@Service
public class PlotService {

	private PlotRepository mPlotRepository;

	public PlotService(PlotRepository plotRepository) {
		this.mPlotRepository = plotRepository;
	}
	
	public List<Plot> getPlots() {
		List<Plot> plots = new ArrayList<>();
		mPlotRepository.findAll().forEach(plots::add);
		return plots;
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
	
}
