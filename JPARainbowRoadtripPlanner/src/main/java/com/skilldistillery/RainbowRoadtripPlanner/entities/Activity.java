package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="did_stop")
	private boolean didStop;
	
	private String description;
	
	@Column(name="priority_level")
	private int priorityLevel;
	
	@Column(name="time_to_spend")
	private String timeToSpend;
	
	@ManyToOne
	@JoinColumn(name="destination_id")
	private Destination destinations;

	public Activity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDidStop() {
		return didStop;
	}

	public void setDidStop(boolean didStop) {
		this.didStop = didStop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getTimeToSpend() {
		return timeToSpend;
	}

	public void setTimeToSpend(String timeToSpend) {
		this.timeToSpend = timeToSpend;
	}

	public Destination getDestinations() {
		return destinations;
	}

	public void setDestinations(Destination destinations) {
		this.destinations = destinations;
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
		Activity other = (Activity) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Activity [id=").append(id).append(", didStop=").append(didStop).append(", description=")
				.append(description).append(", priorityLevel=").append(priorityLevel).append(", timeToSpend=")
				.append(timeToSpend).append("]");
		return builder.toString();
	}
	
	
	
	

}
