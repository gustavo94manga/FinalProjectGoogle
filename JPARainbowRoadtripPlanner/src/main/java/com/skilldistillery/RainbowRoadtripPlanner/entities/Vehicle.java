package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String make;
	
	private String model;
	
	@Column(name="estimated_mpg")
	private int estimatedMPG;
	
	@Column(name="estimated_range")
	private double estimatedRange;
	
	private int capacity;
	
	@Column(name="is_electric")
	private boolean isElectric;

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

	public int getEstimatedMPG() {
		return estimatedMPG;
	}

	public void setEstimatedMPG(int estimatedMPG) {
		this.estimatedMPG = estimatedMPG;
	}

	public double getEstimatedRange() {
		return estimatedRange;
	}

	public void setEstimatedRange(double estimatedRange) {
		this.estimatedRange = estimatedRange;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
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
