package com.skilldistillery.RainbowRoadtripPlanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{
	Trip findById(int id);
}
