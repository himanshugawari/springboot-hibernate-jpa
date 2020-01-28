package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}

	public void save(Course course) {

		if (course.getName() == null)
			entityManager.persist(course);
		else
			entityManager.merge(course);
	}

	// entity manager tracks all the creates updates n deletes in an transaction(i.e
	// method)
	public void playWithEntityManager() {
		System.out.println("playWithEntityManager ---------------- starts here");
		log.info("playWithEntityManager -------------------- starts here");

		Course course1 = new Course("Web Services in 100 Steps");
		entityManager.persist(course1);
		// can be used any number of times to send data to database
		entityManager.flush();

		course1.setName("Web Services in 100 Steps -- UPdated");
		// data from database is taken instead of updated course1
		entityManager.refresh(course1);

		Course course2 = new Course("React in 100 Steps");
		entityManager.persist(course2);
		// sends the data to database till that flush call
		entityManager.flush();

		// can be used in place of detach to clear all including course1 and course2 in
		// one call no changes will be reflected in database after clear call
		entityManager.clear();
		// no longer managed by the entity manager transaction(i.e course2 will not be
		// updated)
		entityManager.detach(course2);
		course2.setName("React in 100 Steps -- UPdated");
	}

	public void addHardcodedReviewsForCourse() {
		Course course = findById(104L);
		log.info("course.getReviews()  ->  {}", course.getReviews());

		Review review1 = new Review("5", "Great hand on course");
		Review review2 = new Review("5", "Hatsoff");

		course.addReviews(review1);
		review1.setCourse(course);

		course.addReviews(review2);
		review2.setCourse(course);

		entityManager.persist(review1);
		entityManager.persist(review2);
	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		log.info("course.getReviews()  ->  {}", course.getReviews());
		for (Review review : reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
	}
}
