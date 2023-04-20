package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import com.skilldistillery.RainbowRoadtripPlanner.entities.User;

public interface UserService {
	List<User> listAllUsers();
	User findByUsername(String username);
	User create(User user);
	User update(int id, User user);
	boolean deleteById(int id);
}
