package com.khurley.quiz.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.khurley.quiz.entity.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

	/**
	 * Returns a Quiz that match with the passed title.
	 * 
	 * @param tittle
	 *            the title
	 * @return the quiz if was found
	 */
	Quiz findByTitle(String title);

	/**
	 * Returns all Quizzes matching this the title snippet passed
	 * 
	 * @param title
	 *            the title snippet
	 * @return all quizzes found
	 */
	Page<Quiz> findByTitleContaining(String title, Pageable pageable);

	/**
	 * Returns a {@link Page} of {@link Quiz}s having a comment which contains
	 * the given snippet.
	 * 
	 * @param comments
	 * @param pageable
	 * @return
	 */
	Page<Quiz> findByCommentsContaining(String comments, Pageable pageable);
}
