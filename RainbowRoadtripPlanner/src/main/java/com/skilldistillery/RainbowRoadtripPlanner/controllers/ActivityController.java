package com.skilldistillery.RainbowRoadtripPlanner.controllers;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skilldistillery.RainbowRoadtripPlanner.entities.Activity;
import com.skilldistillery.RainbowRoadtripPlanner.services.ActivityService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class ActivityController {
	
	
	@Autowired 
	private ActivityService actSrvc;
	
	
	@GetMapping("activities")
	public List<Activity> index(){
		return actSrvc.index();
	}
	
	@GetMapping("activities/{id}")
	public Activity findById(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		try {
			Activity activity = actSrvc.findById(id);
				res.setStatus(201);
				res.setHeader("Location", "http://localhost:8090/api/activites/" +activity.getId());
				return activity;
			}catch(Exception e){
				e.printStackTrace();
				res.setStatus(400);
			}
			return null;
	}
	
	
	@PostMapping("activities")
	public Activity create(HttpServletRequest req, HttpServletResponse res, @RequestBody Activity activity) {
		
		try {
			activity = actSrvc.create(activity);
			res.setStatus(201);
			res.setHeader("Location", "http://localhost:8090/api/activities" +activity.getId());
		}catch(Exception e){
			e.printStackTrace();
			res.setStatus(400);
		}
		return activity;
		
	}
	
	@PutMapping("activities/{id}")
	public Activity update(HttpServletRequest req, HttpServletResponse res, @RequestBody Activity activity, @PathVariable int id) {
		
		try {
				activity = actSrvc.update(activity, id);
			if(activity ==null) {
				res.setStatus(404);
			}
			}catch(Exception e){
				e.printStackTrace();
				res.setStatus(400);
				activity = null;
			}
		
		
		return activity;
	}
	
	
	
	
	
	@DeleteMapping("activities/{id}")
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		
		try {
			if (actSrvc.destroy(id)) {
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
