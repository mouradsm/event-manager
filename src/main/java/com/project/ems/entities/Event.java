package com.project.ems.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

// This class represents an entity to a certain event that will be created by a user


@Entity
public class Event  implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	// Name of the event
	private String name;
	
	// Place where the event will happen
	private String place;
	
	// Date of the event
	private String date;
	
	// A description to the event
	private String description;
	
	// Type of the event
	private String type;

	
	// Default constructor
	public Event() {

	}

	public Event(String name, String place, String date, String description, String type) {
		super();
		this.name = name;
		this.place = place;
		this.date = date;
		this.description = description;
		this.type= type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
