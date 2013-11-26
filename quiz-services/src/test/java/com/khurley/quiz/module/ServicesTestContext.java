package com.khurley.quiz.module;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.khurley.quiz.dao.QuizRepository;

@Configuration
@ComponentScan("com.khurley.quiz.module.services")
@Import(ServicesContext.class)
public class ServicesTestContext {

	@Bean
	public QuizRepository quizRepository() {
		return mock(QuizRepository.class);
	}
	
}
