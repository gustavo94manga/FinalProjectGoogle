package com.skilldistillery.RainbowRoadtripPlanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Comment;
import com.skilldistillery.RainbowRoadtripPlanner.entities.User;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.CommentRepository;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Comment> showAll(String username) {
		return commentRepo.findByUser_Username(username);
	}

	@Override
	public Comment show(String username, int id) {
		return commentRepo.findById(id);
	}

	@Override
	public Comment create(String username, Comment comment) {
		User user = userRepo.findByUsername(username);
		if(user != null) {
			commentRepo.saveAndFlush(comment);
		}
		return null;
	}

	@Override
	public Comment update(String username, int id, Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(String username, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}