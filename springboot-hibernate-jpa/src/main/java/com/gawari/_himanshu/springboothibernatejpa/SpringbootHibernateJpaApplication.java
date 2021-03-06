package com.gawari._himanshu.springboothibernatejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gawari._himanshu.springboothibernatejpa.entity.Course;
import com.gawari._himanshu.springboothibernatejpa.entity.FullTimeEmployee;
import com.gawari._himanshu.springboothibernatejpa.entity.PartTimeEmployee;
import com.gawari._himanshu.springboothibernatejpa.entity.Review;
import com.gawari._himanshu.springboothibernatejpa.entity.Student;
import com.gawari._himanshu.springboothibernatejpa.repository.CourseRepository;
import com.gawari._himanshu.springboothibernatejpa.repository.EmployeeRepository;
import com.gawari._himanshu.springboothibernatejpa.repository.StudentRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class SpringbootHibernateJpaApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * employeeRepository.insertEmployee(new FullTimeEmployee("JACK", new
		 * BigDecimal("10000"))); employeeRepository.insertEmployee(new
		 * PartTimeEmployee("JILL", new BigDecimal("50")));
		 * //log.info("All employees -> {}",employeeRepository.retrieveAllEmployees().
		 * toString()); //use this when using @MappedSuperclass
		 * log.info("FullTime employees -> {}",employeeRepository.
		 * retrieveAllFullTimeEmployees().toString());
		 * log.info("PartTime employees -> {}",employeeRepository.
		 * retrieveAllPartTimeEmployees().toString());
		 */
		
		//studentRepository.insertStudentAndCourse(new Student("JACK"), new Course("Microservices in 100 Steps"));
		
		//studentRepository.insertHardcodedStudentAndCourse();
		
		/*
		 * List<Review> reviews = new ArrayList<>(); reviews.add(new Review("5",
		 * "Great hand on course")); reviews.add(new Review("5", "Hatsoff"));
		 * courseRepository.addReviewsForCourse(103L, reviews);
		 */
		// courseRepository.addHardcodedReviewsForCourse();
		// studentRepository.saveStudentWithPassport();
		// courseRepository.playWithEntityManager();

		/*
		 * log.info(courseRepository.findById(100L).toString());
		 * log.info(courseRepository.findById(103L).toString());
		 * courseRepository.deleteById(104L);
		 * log.info("Id 104 deleted courseRepository.deleteById(104L)");
		 * courseRepository.save(new Course("Atsuko"));
		 */
	}

}
