package com.khurley.quiz.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * testing that Quiz.Builder is working fine.
 * 
 * @author khurley
 * 
 */
public class QuizTest {

	private static final String TITLE = "title";
	private static final String COMMENTS = "comments";

	@Test
	public void test_create() {
		Quiz quiz = new Quiz(TITLE, COMMENTS);
		
		assertEquals(TITLE, quiz.getTitle());
		assertEquals(COMMENTS, quiz.getComments());
	}
}
