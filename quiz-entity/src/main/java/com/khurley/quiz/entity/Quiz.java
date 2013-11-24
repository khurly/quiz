package com.khurley.quiz.entity;

/**
 * Dummy class for managing quiz
 * 
 * @author khurley
 * 
 */
public class Quiz {

	private Integer id;

	private String title;

	private String comments;

	public String getComments() {
		return comments;
	}

	public String getTitle() {
		return title;
	}

	public Integer getId() {
		return id;
	}

	public static class Builder {

		private Integer id;
		private String title;
		private String comments;

		public Builder id(Integer val) {
			this.id = val;
			return this;
		}

		public Builder title(String val) {
			this.title = val;
			return this;
		}

		public Builder comments(String val) {
			this.comments = val;
			return this;
		}

		public Quiz build() {
			Quiz quiz = new Quiz();
			quiz.comments = this.comments;
			quiz.id = this.id;
			quiz.title = this.title;
			return quiz;
		}
	}
}
