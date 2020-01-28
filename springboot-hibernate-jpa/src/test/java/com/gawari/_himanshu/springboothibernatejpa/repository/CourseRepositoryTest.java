package com.gawari._himanshu.springboothibernatejpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.Review;

@SpringBootTest
class CourseRepositoryTest {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Disabled
	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Disabled
	@Test
	void findByIdTest() {
		log.info(courseRepository.findById(101L).toString());
		assertEquals("JPA in 50 Steps", courseRepository.findById(101L).getName());
	}

	@Disabled
	@Test
	// @DirtiesContext -- resets data before test
	@DirtiesContext
	public void deleteByIdTest() {
		courseRepository.deleteById(100L);
		assertNull(courseRepository.findById(100L));

	}

	@Disabled
	@Test
	@DirtiesContext
	public void saveTest() {
		Course c = courseRepository.findById(100L);
		assertEquals("Himanshu", c.getName());
		c.setName("Himanshu Gawari");

		courseRepository.save(c);

		Course c1 = courseRepository.findById(100L);
		assertEquals("Himanshu Gawari", c1.getName());
	}

	@Disabled
	@Test
	@DirtiesContext
	public void playWithEntityManagerTest() {
		courseRepository.playWithEntityManager();
	}

	@Disabled
	@Test
	@Transactional
	public void retriewReviewsForCourse() {
		Course course = courseRepository.findById(101L);
		log.info("{}", course.getReviews());
	}
	
	@Test
	@Transactional
	public void retriewReviewsForReview() {
		Review review = entityManager.find(Review.class, 501L);
		log.info("{}", review.getCourse());
	}
}
