package com.khurley.quiz.entity;

import org.junit.Test;

public class QuizTest {

	private static final int ID = 1;
	private static final String TITLE = "title";
	private static final String COMMENTS = "comments";

	@Test
	public void test_create() {
		Quiz quiz = Quiz.builder().id(ID).title(TITLE).comments(COMMENTS)
				.build();
		System.out.println("coco");
	}
}
