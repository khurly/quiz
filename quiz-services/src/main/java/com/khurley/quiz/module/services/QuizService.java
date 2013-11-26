package com.khurley.quiz.module.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.khurley.quiz.dao.QuizRepository;
import com.khurley.quiz.entity.Quiz;

@Component
public class QuizService implements com.khurley.quiz.api.services.QuizService {

	private QuizRepository quizRepository;

	@Autowired
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	@Override
	public long createQuiz(Quiz quiz) {
		return quizRepository.save(quiz).getId();
	}

	@Override
	public void deleteQuiz(long id) {
		quizRepository.delete(id);
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		quizRepository.save(quiz);
	}

	@Override
	public Iterable<Quiz> retrieveAll() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz retrieveQuiz(long id) {
		return quizRepository.findOne(id);
	}

	@Override
	public Quiz retrieveQuizByTitle(String title) {
		return quizRepository.findByTitle(title);
	}

	@Override
	public Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet) {
		return quizRepository.findByTitleContaining(titleSnippet,
				new PageRequest(0, 50));
	}

	@Override
	public Page<Quiz> retrieveQuizByTitleSnippet(String titleSnippet, int page,
			int size) {
		return quizRepository.findByTitleContaining(titleSnippet,
				new PageRequest(page, size));
	}

}
