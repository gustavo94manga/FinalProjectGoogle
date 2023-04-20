package com.skilldistillery.RainbowRoadtripPlanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Vehicle;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepo;

	@Override
	public Vehicle getVehicleById(int id) {
		
		return vehicleRepo.findById(id);
	}
	
	

}
