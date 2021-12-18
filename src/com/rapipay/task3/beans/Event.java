package com.rapipay.task3.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "eventName")
	private String eventName;
	@Column(name = "eventPlace")
	private String eventPlace;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedback;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(String eventName, String eventPlace ) {
		super();
		this.eventName = eventName;
		this.eventPlace = eventPlace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventName, eventPlace, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(eventName, other.eventName) && Objects.equals(eventPlace, other.eventPlace)
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventPlace=" + eventPlace + ", feedback=" + feedback
				+ "]";
	}

}
