package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import javax.annotation.processing.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="activity_rating")
public class ActivityRating {
	
	@EmbeddedId
	private ActivityRatingId id;
		
	private int rating;
	
	@Column(name="rating_comment")
	private String ratingComment;
	
	@CreationTimestamp
	@Column(name="rating_date")
	private LocalDateTime ratingDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id") // DB column name
	@MapsId(value = "userId")     // Field in ID class
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "activity_id") // DB column
	@MapsId(value = "activityId")     // Field in ID class
	private Activity activity;
	
	public ActivityRating() {
		
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

	public LocalDateTime getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(LocalDateTime ratingDAte) {
		this.ratingDate = ratingDAte;
	}

	public ActivityRatingId getId() {
		return id;
	}

	public void setId(ActivityRatingId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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
		return "ActivityRating [id=" + id + ", rating=" + rating + ", ratingComment=" + ratingComment + ", ratingDate="
				+ ratingDate + "]";
	}
	
	
}
