package com.skilldistillery.RainbowRoadtripPlanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Comment;
import com.skilldistillery.RainbowRoadtripPlanner.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public Comment getCommentByCommentId(int commentId) {
		
		return null;
	}

}
