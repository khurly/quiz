package com.khurley.quiz.module.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khurley.quiz.api.services.QuizService;
import com.khurley.quiz.dao.QuizRepository;
import com.khurley.quiz.entity.Quiz;
import com.khurley.quiz.module.ServicesTestContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServicesTestContext.class)
public class QuizServiceTest {

	private static final long QUIZ_ID = 20;
	private static final Quiz QUIZ = spy(new Quiz("title", "comments"));
	
	@Resource
	private QuizRepository repository;
	
	@Autowired
	private QuizService service;
	
	@Before
	public void setUp() {
		doReturn(QUIZ_ID).when(QUIZ).getId();
	}
	
	@Test
	public void test_create() {
		when(repository.save(QUIZ)).thenReturn(QUIZ);
		
		assertEquals(QUIZ_ID, service.createQuiz(QUIZ));
		
		verify(repository, only()).save(eq(QUIZ));
		verify(QUIZ, only()).getId();
	}
	

}
