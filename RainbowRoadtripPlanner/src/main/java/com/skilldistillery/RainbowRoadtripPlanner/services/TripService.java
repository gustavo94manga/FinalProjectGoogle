package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Trip;

public interface TripService {
	public List<Trip> index();
	public Trip create(Trip trip);
	public Trip update(Trip trip, int id);
	public boolean destroy(int id);
}
