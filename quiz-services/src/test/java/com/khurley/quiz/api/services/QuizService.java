package com.khurley.quiz.api.services;

import org.springframework.data.domain.Page;

import com.khurley.quiz.entity.Quiz;

public interface QuizService {

	long createQuiz(Quiz quiz);

	void deleteQuiz(long id);

	void updateQuiz(Quiz quiz);

	Iterable<Quiz> retrieveAll();

	Quiz retrieveQuiz(long id);

	Quiz retrieveQuizByTitle(String title);

	Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet);

	Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet, int page,
			int size);
}
