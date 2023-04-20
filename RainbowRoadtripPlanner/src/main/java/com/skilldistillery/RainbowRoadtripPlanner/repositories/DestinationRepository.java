package com.skilldistillery.RainbowRoadtripPlanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer>{
	
		Destination findByAddress_Id(int id);
		Destination findById(int id);
}
