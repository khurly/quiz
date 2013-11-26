package com.khurley.quiz.module.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.khurley.quiz.dao.QuizRepository;
import com.khurley.quiz.entity.Quiz;

@Component
public class QuizService implements com.khurley.quiz.api.services.QuizService {

	private QuizRepository repository;

	@Autowired
	public QuizService(QuizRepository repository) {
		this.repository = repository;
	}

	@Override
	public long createQuiz(Quiz quiz) {
		return repository.save(quiz).getId();
	}

	@Override
	public void deleteQuiz(long id) {
		repository.delete(id);
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		repository.save(quiz);
	}

	@Override
	public Iterable<Quiz> retrieveAll() {
		return repository.findAll();
	}

	@Override
	public Quiz retrieveQuiz(long id) {
		return repository.findOne(id);
	}

	@Override
	public Quiz retrieveQuizByTitle(String title) {
		return repository.findByTitle(title);
	}

	@Override
	public Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet) {
		return repository.findByTitleContaining(titleSnippet, new PageRequest(
				0, 50));
	}

	@Override
	public Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet, int page,
			int size) {
		return repository.findByTitleContaining(titleSnippet, new PageRequest(
				page, size));
	}

}
