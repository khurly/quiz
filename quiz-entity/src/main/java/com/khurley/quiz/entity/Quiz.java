package com.khurley.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dummy class for managing quiz
 * 
 * @author khurley
 * 
 */
@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "comments")
	private String comments;

	public Quiz(String title, String comments) {
		this.title = title;
		this.comments = comments;
	}

	protected Quiz() {
		// hibernate requires allways
	}

	public String getComments() {
		return comments;
	}

	public String getTitle() {
		return title;
	}

	public long getId() {
		return id;
	}
}
