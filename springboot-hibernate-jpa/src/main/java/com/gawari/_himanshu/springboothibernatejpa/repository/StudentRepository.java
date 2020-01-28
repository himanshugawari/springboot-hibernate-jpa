package com.gawari._himanshu.springboothibernatejpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.Passport;
import com.gawari._himanshu.springboothibernatejpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	EntityManager entityManager;

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	public void deleteById(Long id) {
		entityManager.remove(findById(id));
	}

	public void save(Student student) {

		if (student.getName() == null)
			entityManager.persist(student);
		else
			entityManager.merge(student);
	}

	public void saveStudentWithPassport() {
		Passport passport1 = new Passport("Z123456");
		entityManager.persist(passport1);

		Student student1 = new Student("Mike");
		student1.setPassport(passport1);
		entityManager.persist(student1);

	}
	
	public void insertHardcodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 Steps");
		entityManager.persist(student);
		entityManager.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		//Persist the owning side
		entityManager.persist(student);
	}
	
	
	public void insertStudentAndCourse(Student student,Course course) {
		//Student student = new Student("Jack");
		//Course course = new Course("Microservices in 100 Steps");
		student.addCourse(course);
		course.addStudents(student);
		entityManager.persist(student);
		entityManager.persist(course);
	}

	// entity manager tracks all the creates updates n deletes in an transaction(i.e
	// method)
	public void playWithEntityManager() {
		System.out.println("playWithEntityManager ---------------- starts here");
		log.info("playWithEntityManager -------------------- starts here");

		Student student1 = new Student("Web Services in 100 Steps");
		entityManager.persist(student1);
		// can be used any number of times to send datat to database
		entityManager.flush();

		student1.setName("Web Services in 100 Steps -- UPdated");
		// data from database is taken instead of updated student1
		entityManager.refresh(student1);

		Student student2 = new Student("React in 100 Steps");
		entityManager.persist(student2);
		// sends the data to database till that flush call
		entityManager.flush();

		// can be used in place of detach to clear all including student1 and student2
		// in one call no changes will be reflected in database after clear call
		entityManager.clear();
		// no longer managed by the entity manager transaction(i.e student2 will not be
		// updated)
		entityManager.detach(student2);
		student2.setName("React in 100 Steps -- UPdated");
	}
}
