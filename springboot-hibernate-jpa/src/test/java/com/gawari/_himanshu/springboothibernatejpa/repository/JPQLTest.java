package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.Student;

@SuppressWarnings("unchecked")
@SpringBootTest
class JPQLTest {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

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
	@SuppressWarnings("rawtypes")
	@Test
	void JPQL_Basic() {
		log.info("------------INSIDE JPQL----------------------------------------------");
		Query query = entityManager.createQuery("Select c From Course c");
		List resultList = query.getResultList();
		log.info("select c from course c  -> {}", resultList);

	}

	@Disabled
	@Test
	void JPQL_Typed() {
		log.info("------------INSIDE TYPED JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("select c from course c  -> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_When() {
		log.info("------------INSIDE When JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c Where name Like '%100 Steps'",
				Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c Where name Like '%100 Steps'  -> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_Named_Query() {
		log.info("------------INSIDE Named JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("select c from course c  NAMED QUERY-> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_When_Named_Query() {
		log.info("------------INSIDE When NAMED JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_100_step_courses", Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Select c From Course c Where name Like '%100 Steps'  -> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_courses_without_students() {
		log.info("------------INSIDE  JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c Where c.students is EMPTY",
				Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Results  -> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_courses_with_atleast_2_students() {
		log.info("------------INSIDE  JPQL----------------------------------------------");
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c Where Size(c.students) >=2",
				Course.class);
		List<Course> resultList = query.getResultList();
		log.info("Result -> {}", resultList);
	}

	@Disabled
	@Test
	void JPQL_students_with_passport_in_certain_pattern() {
		log.info("------------INSIDE  JPQL----------------------------------------------");
		TypedQuery<Student> query = entityManager
				.createQuery("Select c From Student c Where c.passport.number like '%123%'", Student.class);
		List<Student> resultList = query.getResultList();
		log.info("Select c From Student c Where name Like '%123%'  -> {}", resultList);
	}

	
	
	// JOIN -> Select c,s from Course c JOIN c.students s
	// LEFT JOIN -> Select c,s from Course c LEFT JOIN c.students s
	// CROSS JOIN -> Select c, s from Course c, Student s
	@Test
	void join() {
		Query query = entityManager.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("Course -> {}", result[0]);
			log.info("Student -> {}", result[1]);
		}
	}
	
	@Test
	void left_join() {
		Query query = entityManager.createQuery("Select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("Course -> {}", result[0]);
			log.info("Student -> {}", result[1]);
		}
	}
	
	@Test
	void cross_join() {
		Query query = entityManager.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			log.info("Course -> {}", result[0]);
			log.info("Student -> {}", result[1]);
		}
	}

}
