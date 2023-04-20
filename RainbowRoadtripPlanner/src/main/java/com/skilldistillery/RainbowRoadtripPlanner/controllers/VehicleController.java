package com.skilldistillery.RainbowRoadtripPlanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Vehicle;
import com.skilldistillery.RainbowRoadtripPlanner.services.VehicleService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class VehicleController {
	
	@Autowired
	private VehicleService vehicalService;
	
	@GetMapping("vehicles/{id}")
	public Vehicle getVehicleById(@PathVariable int id) {
		return vehicalService.getVehicleById(id);
		
	}
	
	
	
	
	
	
	
	
}
