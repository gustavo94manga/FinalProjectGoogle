package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Destination;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationRepository destinationRepo;

	@Override
	public List<Destination> index() {
		// TODO Auto-generated method stub
		return destinationRepo.findAll();
	}

	@Override
	public Destination findByAddressId(int id) {
		// TODO Auto-generated method stub
		return destinationRepo.findByAddress_Id(id);
	}

	@Override
	public Destination create(Destination destination) {
		if(destination != null) {
			destinationRepo.saveAndFlush(destination);
		}
		return destination;
	}

	@Override
	public boolean destroy(int id) {
		boolean didDelete = false;
		Destination toDelete =destinationRepo.findById(id);
		destinationRepo.delete(toDelete);
				if(!destinationRepo.existsById(id)) {
					didDelete = true;
					}
			
			
			return didDelete;
	}

	@Override
	public Destination update(Destination dest, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
