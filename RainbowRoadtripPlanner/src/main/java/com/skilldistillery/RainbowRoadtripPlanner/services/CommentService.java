package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Comment;

public interface CommentService {
	
	public Comment show(String username, int id);
	
	public List<Comment> showAll(String username);
	
	public Comment create(String username, Comment comment);
	
	public Comment update(String username, int id, Comment comment);
	
	public boolean destroy(String username, int id);

}