package com.khurley.quiz.entity;

import static com.khurley.quiz.entity.Quiz.builder;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * testing that Quiz.Builder is working fine.
 * 
 * @author khurley
 * 
 */
public class QuizTest {

	private static final int ID = 1;
	private static final String TITLE = "title";
	private static final String COMMENTS = "comments";

	@Test
	public void test_create() {
		Quiz quiz = builder().id(ID).title(TITLE).comments(COMMENTS).build();
		assertEquals(ID, quiz.getId());
		assertEquals(TITLE, quiz.getTitle());
		assertEquals(COMMENTS, quiz.getComments());
	}
}
