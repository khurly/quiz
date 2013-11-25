package com.khurley.quiz.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khurley.quiz.EntityContext;
import com.khurley.quiz.entity.Quiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EntityContext.class)
public class QuizRepositoryTest {

	private static final String TITLE = "new title";
	private static final String COMMENTS = "some comments";

	@Autowired
	private QuizRepository repository;

	@Test
	public void insert_quiz() {
		Quiz quiz = new Quiz(TITLE, COMMENTS);
		Quiz safeQuiz = repository.save(quiz);
		System.out.println(safeQuiz.getId());

		repository.delete(quiz);

	}
}
