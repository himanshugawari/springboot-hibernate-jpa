package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;

//@SuppressWarnings({ "unchecked", "rawtypes" })
@SpringBootTest
class CriteriaQueryTest {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	EntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Disabled
	@Test
	void Criteria_Query_Basic_all_courses() {
		log.info("------------INSIDE Criteria Query----------------------------------------------");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Query -> {}", resultList);

		/*
		 * log.
		 * info("------------INSIDE JPQL----------------------------------------------"
		 * );
		 * 
		 * TypedQuery<Course> query =
		 * entityManager.createQuery("Select c From Course c",Course.class);
		 * List<Course> resultList = query.getResultList();
		 * log.info("Typed Query -> {}", resultList);
		 */

	}

	@Disabled
	@Test
	void all_courses_having_100_steps() {
		log.info("------------INSIDE Criteria Query----------------------------------------------");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		Predicate like100Steps = criteriaBuilder.like(courseRoot.get("name"), "%100 Steps");

		criteriaQuery.where(like100Steps);

		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Query -> {}", resultList);
	}

	@Disabled
	@Test
	void all_courses_without_students() {
		log.info("------------INSIDE Criteria Query----------------------------------------------");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		Predicate studentsIsEmpty = criteriaBuilder.isEmpty(courseRoot.get("students"));

		criteriaQuery.where(studentsIsEmpty);

		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Query -> {}", resultList);
	}

	@Disabled
	@Test
	void join() {
		log.info("------------INSIDE Criteria Query----------------------------------------------");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		courseRoot.join("students");

		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Query -> {}", resultList);
	}

	@Test
	void left_join() {
		log.info("------------INSIDE Criteria Query----------------------------------------------");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);

		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Query -> {}", resultList);
	}

}
