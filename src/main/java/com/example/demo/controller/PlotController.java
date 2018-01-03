package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Plot;
import com.example.demo.service.PlotService;

@RestController
@RequestMapping(value = "/plot")
public class PlotController {
	
	private PlotService mPlotService;

	public PlotController(PlotService plotService) {
		this.mPlotService = plotService;
	}
	
	@RequestMapping
	public List<Plot> getUsers() {
		return mPlotService.getPlots();
	}
	
	@RequestMapping(value = "/part/{page}")
	public List<Plot> getUserPage(@PathVariable Integer pageNumber) {
		Page<Plot> plotPage = mPlotService.getPlotsPart(pageNumber);
		return plotPage.getContent();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addGroup(@RequestBody Plot plot) {
		mPlotService.addPlot(plot);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> removeGroup(@RequestParam("plotId") String plotId) {
		mPlotService.removePlot(Long.valueOf(plotId));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
