package com.khurley.quiz.module;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.khurley.quiz.api.services.QuizService;

public class ServicesContextTest {

	@Test
	public void test_service_context() {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ServicesApplicationContext.class);
		assertNotNull(context);
		assertNotNull(context.getBean(QuizService.class));
	}
}
