package com.khurley.quiz;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khurley.quiz.dao.QuizRepository;

public class EntityContextTest {

	@Test
	public void test_entity_context() {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				EntityContext.class);
		assertNotNull(context);
		assertNotNull(context.getBean(QuizRepository.class));
	}
}
