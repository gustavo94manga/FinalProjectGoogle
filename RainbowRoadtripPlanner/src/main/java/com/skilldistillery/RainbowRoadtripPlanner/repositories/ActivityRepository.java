package com.skilldistillery.RainbowRoadtripPlanner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
		Activity findByPriorityLevel(int lvl);
                List<Activity> findByDestinations_Id(int destinationId);  // note the plural + _Id
		Activity findById(int id);
	
	
}
