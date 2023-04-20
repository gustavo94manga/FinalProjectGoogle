package com.skilldistillery.RainbowRoadtripPlanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	Vehicle findById(int id);

}
