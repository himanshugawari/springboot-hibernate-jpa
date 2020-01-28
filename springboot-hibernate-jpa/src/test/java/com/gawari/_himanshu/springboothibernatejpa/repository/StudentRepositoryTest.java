package com.gawari._himanshu.springboothibernatejpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.Passport;
import com.gawari._himanshu.springboothibernatejpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	StudentRepository studentRepository;

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
	@Transactional
	void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 201L);
		log.info("Student -> {}", student);
		log.info("Passport -> {}", student.getPassport());
	}

	@Disabled
	@Test
	@Transactional
	void retrievePassportAndAssociateDetails() {
		Passport passport = entityManager.find(Passport.class, 401L);
		log.info("Passport -> {}", passport);
		log.info("Student -> {}", passport.getStudent());
	}

	@Disabled
	@Test
	@Transactional
	void retrieveStudentAndCourse() {
		Student student = entityManager.find(Student.class, 201L);
		log.info("Student -> {}", student);
		log.info("Courses -> {}", student.getCourses());
	}

	@Test
	@Transactional
	void retrieveCourseAndStudent() {
		Course course = entityManager.find(Course.class, 101L);
		log.info("Course -> {}", course);
		log.info("Students -> {}", course.getStudents());
	}
}
