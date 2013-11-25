package com.khurley.quiz.dao;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getOnlyElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Predicate;
import com.khurley.quiz.EntityContext;
import com.khurley.quiz.entity.Quiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EntityContext.class)
public class QuizRepositoryTest {

	private static final String TITLE = "new title";
	private static final String COMMENTS = "some comments";

	private static final Predicate<Quiz> TITLE_PREDICATE = new Predicate<Quiz>() {
		@Override
		public boolean apply(Quiz quiz) {
			return TITLE.equals(quiz.getTitle());
		}
	};

	private static final Predicate<Quiz> COMMENTS_PREDICATE = new Predicate<Quiz>() {
		@Override
		public boolean apply(Quiz quiz) {
			return COMMENTS.equals(quiz.getComments());
		}
	};

	private Quiz newQuiz;

	@Autowired
	private QuizRepository repository;

	@Before
	public void setUp() {
		Quiz quiz = new Quiz(TITLE, COMMENTS);

		newQuiz = repository.save(quiz);

		assertNotNull(newQuiz);
		assertNotNull(newQuiz.getId());

		assertEquals(quiz.getComments(), newQuiz.getComments());
		assertEquals(quiz.getTitle(), newQuiz.getTitle());
	}

	@Test
	public void test_create_and_delete() {
		// executing before and after
	}

	@Test
	public void test_find_by_title() {
		Quiz foundQuiz = repository.findByTitle(TITLE);
		assertNotNull(foundQuiz);
	}

	@Test
	public void test_find_by_containing_full_title() {
		testFindByContainingTitleSnippet(TITLE);
	}

	@Test
	public void test_find_by_containing_title_snippet() {
		testFindByContainingTitleSnippet(TITLE.substring(1, 3));
	}

	private void testFindByContainingTitleSnippet(String titleSnippet) {
		Page<Quiz> quizPage = repository.findByTitleContaining(titleSnippet,
				new PageRequest(0, 10));
		assertTrue(quizPage.hasContent());

		Quiz foundQuiz = getOnlyElement(filter(quizPage, TITLE_PREDICATE));
		assertNotNull(foundQuiz);
	}
	
	@Test
	public void test_find_by_containing_full_comments() {
		testFindByContainingCommentsSnippet(COMMENTS);
	}

	@Test
	public void test_find_by_containing_comments_snippet() {
		testFindByContainingCommentsSnippet(COMMENTS.substring(1, 7));
	}

	private void testFindByContainingCommentsSnippet(String commentSnippet) {
		Page<Quiz> quizPage = repository.findByCommentsContaining(
				commentSnippet, new PageRequest(0, 10));
		assertTrue(quizPage.hasContent());

		Quiz foundQuiz = getOnlyElement(filter(quizPage, COMMENTS_PREDICATE));
		assertNotNull(foundQuiz);
	}

	@After
	public void turnDown() {
		long id = newQuiz.getId();
		repository.delete(newQuiz);

		Quiz deletedQuiz = repository.findOne(id);

		assertNull(deletedQuiz);
	}

}
