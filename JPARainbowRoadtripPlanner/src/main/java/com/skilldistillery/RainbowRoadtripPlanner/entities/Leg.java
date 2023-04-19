package com.skilldistillery.RainbowRoadtripPlanner.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="estimated_miles")
	private int estimatedMiles;
	
	@Column(name="actual_miles")
	private int actualMiles;
	
	private String name;
	
	private String description;
	
	@Column(name="leg_number")
	private Integer legNumber;
	
	private String notes;

	public Leg() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstimatedMiles() {
		return estimatedMiles;
	}

	public void setEstimatedMiles(int estimatedMiles) {
		this.estimatedMiles = estimatedMiles;
	}

	public int getActualMiles() {
		return actualMiles;
	}

	public void setActualMiles(int actualMiles) {
		this.actualMiles = actualMiles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(Integer legNumber) {
		this.legNumber = legNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
		Leg other = (Leg) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Leg [id=").append(id).append(", estimatedMiles=").append(estimatedMiles)
				.append(", actualMiles=").append(actualMiles).append(", name=").append(name).append(", description=")
				.append(description).append(", legNumber=").append(legNumber).append(", notes=").append(notes)
				.append("]");
		return builder.toString();
	}
	
	

}
