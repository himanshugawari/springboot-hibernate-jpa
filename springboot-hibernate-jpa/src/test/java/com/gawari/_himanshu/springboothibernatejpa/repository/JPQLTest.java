package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;

@SpringBootTest
class JPQLTest {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	EntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@SuppressWarnings("rawtypes")
	@Test
	void JPQL_Basic() {
		log.info("------------INSIDE JPQL----------------------------------------------");
		Query query = entityManager.createQuery("Select c From Course c");
		List resultList = query.getResultList();
		log.info("select c from course c  -> {}", resultList);

	}

	@Test
	void JPQL_Typed() {
		log.info("------------INSIDE TYPED JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("select c from course c  -> {}", resultList);
	}

	@Test
	void JPQL_When() {
		log.info("------------INSIDE When JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c Where name Like '%100 Steps'",
				Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c Where name Like '%100 Steps'  -> {}", resultList);
	}

	@Test
	void JPQL_Named_Query() {
		log.info("------------INSIDE Named JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("select c from course c  NAMED QUERY-> {}", resultList);
	}

	@Test
	void JPQL_When_Named_Query() {
		log.info("------------INSIDE When NAMED JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_100_step_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c Where name Like '%100 Steps'  -> {}", resultList);
	}
}
