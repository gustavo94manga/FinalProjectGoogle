package com.skilldistillery.RainbowRoadtripPlanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.RainbowRoadtripPlanner.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	Comment findById(int commentId);
}
