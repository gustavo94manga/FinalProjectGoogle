package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.annotation.processing.Generated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String make;
	
	private String model;
	
	@Column(name="estimated_mpg")
	private Integer estimatedMPG;
	
	@Column(name="estimated_range")
	private Double estimatedRange;
	
	private Integer capacity;
	
	@Column(name="is_electric")
	private Boolean isElectric;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vehicle")
	private List<Trip> trips;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Vehicle() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getEstimatedMPG() {
		return estimatedMPG;
	}

	public void setEstimatedMPG(Integer estimatedMPG) {
		this.estimatedMPG = estimatedMPG;
	}

	public Double getEstimatedRange() {
		return estimatedRange;
	}

	public void setEstimatedRange(Double estimatedRange) {
		this.estimatedRange = estimatedRange;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getIsElectric() {
		return isElectric;
	}

	public void setIsElectric(Boolean isElectric) {
		this.isElectric = isElectric;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Vehicle other = (Vehicle) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [id=").append(id).append(", make=").append(make).append(", model=").append(model)
		.append(", estimatedMPG=").append(estimatedMPG).append(", estimatedRange=").append(estimatedRange)
		.append(", capacity=").append(capacity).append(", isElectric=").append(isElectric).append("]");
		return builder.toString();
	}
}
