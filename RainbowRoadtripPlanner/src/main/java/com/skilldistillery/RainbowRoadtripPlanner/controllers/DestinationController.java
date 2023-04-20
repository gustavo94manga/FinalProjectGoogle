package com.skilldistillery.RainbowRoadtripPlanner.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Destination;
import com.skilldistillery.RainbowRoadtripPlanner.services.DestinationService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class DestinationController {
	
	@Autowired
	private DestinationService destSrvc;
	
	@GetMapping("destination")
	public List<Destination> index(){
		return destSrvc.index();
	}
	
	@GetMapping("destination/address/{id}")
	public Destination findByAddress(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		
		try {
		Destination destination = destSrvc.findByAddressId(id);
			res.setStatus(201);
			res.setHeader("Location", "http://localhost:8090/api/destination" +destination.getId());
			return destination;
		}catch(Exception e){
			e.printStackTrace();
			res.setStatus(400);
		}
		return null;
	}
	
	
	@PostMapping("destination")
	public Destination create(HttpServletRequest req, HttpServletResponse res, @RequestBody Destination destination) {
		try {
			destination = destSrvc.create(destination);
			res.setStatus(201);
			res.setHeader("Location", "http://localhost:8090/api/destination" +destination.getId());
		}catch(Exception e){
			e.printStackTrace();
			res.setStatus(400);
		}
		return destination;
	}
	
	
	@DeleteMapping("destination/{id}")
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		
		try {
			if (destSrvc.destroy(id)) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		

	}
	
	
	
	
	

}

