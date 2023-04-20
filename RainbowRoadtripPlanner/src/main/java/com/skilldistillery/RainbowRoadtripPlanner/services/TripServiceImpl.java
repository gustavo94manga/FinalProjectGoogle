package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Address;
import com.skilldistillery.RainbowRoadtripPlanner.entities.Trip;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.TripRepository;
@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepo;

	@Override
	public List<Trip> index() {
		return tripRepo.findAll();
	}

	@Override
	public Trip create(Trip trip) {
		if (trip != null) {
			return tripRepo.saveAndFlush(trip);
		}
		return trip;
	}

	@Override
	public Trip update(Trip trip, int id) {
		Trip existing = tripRepo.findById(trip, id);
		if (existing != null) {
			existing.setStartDate(trip.getStartDate());
			existing.setEndDate(trip.getEndDate());
			existing.setRoundTrip(trip.isRoundTrip());
			existing.setMiles(trip.getMiles());
			existing.setCreateDate(trip.getCreateDate());
			existing.setUpdateDate(trip.getUpdateDate());
			existing.setTitle(trip.getTitle());
			existing.setDescription(trip.getDescription());
			existing.setImageUrl(trip.getImageUrl());
			tripRepo.saveAndFlush(existing);
			return existing;
		}
	}

	@Override
	public boolean destroy(int id) {
		boolean deleted = false;
		Trip toDelete = tripRepo.findById(id);
		tripRepo.delete(toDelete);
		if (!tripRepo.existsById(id)) {
			deleted = true;
		}
		return deleted;
	}

}
