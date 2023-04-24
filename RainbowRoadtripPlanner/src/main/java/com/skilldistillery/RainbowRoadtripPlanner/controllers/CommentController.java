package com.skilldistillery.RainbowRoadtripPlanner.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.skilldistillery.RainbowRoadtripPlanner.entities.Comment;
import com.skilldistillery.RainbowRoadtripPlanner.services.CommentService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("comments/trip/{id}")
public List<Comment> showAllforTrip(Principal principal,HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		return commentService.showAllTripComments(id);
	}

	@GetMapping("comment/{id}")
public Comment show(Principal principal,HttpServletRequest req, HttpServletResponse res,@PathVariable  int id) {
	Comment findComment = commentService.show(principal.getName(), id); 
	if (findComment == null) {
		res.setStatus(404);
	}
	return findComment;
}
	
	

	@PostMapping("comments")
public Comment create(Principal principal,HttpServletRequest req, @RequestBody Comment comment,HttpServletResponse res) {
	Comment createdComment =  null;
	try {
		createdComment = commentService.create(principal.getName(), comment);
		res.setStatus(201);
	} catch (Exception e) {
		e.printStackTrace();
		res.setStatus(400);
	}
	return createdComment;
	
	}

	@PutMapping("comments/{id}")
public Comment update(Principal principal,HttpServletRequest req, @RequestBody Comment comment,@PathVariable int id, HttpServletResponse res) {
		Comment updated = null;
		try {
				updated = commentService.update(principal.getName(), id, comment);
				if (updated != null) {
				res.setStatus(200);
			} else {
				res.setStatus(400);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return updated;
	}

	@DeleteMapping("comments/{id}")
public boolean destroy(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		boolean deleted = false;
		
		try {
			deleted = commentService.destroy(principal.getName(), id);
			if(deleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
			} catch(Exception e) {
				res.setStatus(500);
			}
		return deleted;
	}
	
	

}