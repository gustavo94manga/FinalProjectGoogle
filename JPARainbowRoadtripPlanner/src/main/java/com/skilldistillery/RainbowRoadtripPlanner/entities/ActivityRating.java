package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="activity_rating")
public class ActivityRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int rating;
	
	@Column(name="rating_comment")
	private String ratingComment;
	
	@CreationTimestamp
	@Column(name="rating_date")
	private LocalDateTime ratingDAte;
	
	public ActivityRating() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRatingComment() {
		return ratingComment;
	}

	public void setRatingComment(String ratingComment) {
		this.ratingComment = ratingComment;
	}

	public LocalDateTime getRatingDAte() {
		return ratingDAte;
	}

	public void setRatingDAte(LocalDateTime ratingDAte) {
		this.ratingDAte = ratingDAte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityRating other = (ActivityRating) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActivityRating [id=").append(id).append(", rating=").append(rating).append(", ratingComment=")
				.append(ratingComment).append(", ratingDAte=").append(ratingDAte).append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
