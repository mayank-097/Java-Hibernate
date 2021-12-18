package com.rapipay.task3.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	private String content;
	private LocalDate feedbackDate;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id ,String content, LocalDate feedbackDate) {
		super();
		this.fid = id;
		this.content = content;
		this.feedbackDate = feedbackDate;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	
	
	

}
