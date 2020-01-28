package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Course;

@SuppressWarnings("rawtypes")
@SpringBootTest
class NativeQueriesTest {

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

	@Test
	void Native_Query_Basic() {
		log.info("------------INSIDE NATIVE QUERY----------------------------------------------");
		Query query = entityManager.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE  -> {}", resultList);
	}

	@Test
	void Native_Query_with_Parameter() {
		log.info("------------INSIDE NATIVE QUERY Passing PARAMETERS----------------------------------------------");
		Query query = entityManager.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
		query.setParameter(1, 101L);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE WHERE id = ?  -> {}", resultList);
	}

	@Test
	void Native_Query_with_named_Parameter() {
		log.info(
				"------------INSIDE NATIVE QUERY Passing named PARAMETERS----------------------------------------------");
		Query query = entityManager.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
		query.setParameter("id", 101L);
		List resultList = query.getResultList();
		log.info("SELECT * FROM COURSE WHERE id = :id  -> {}", resultList);
	}

	@Test
	@Transactional
	void Native_Query_To_Update() {
		log.info("------------INSIDE NATIVE QUERY UPDATE----------------------------------------------");
		Query query = entityManager.createNativeQuery("UPDATE COURSE SET last_updated_date=sysdate()", Course.class);
		int executeUpdate = query.executeUpdate();
		log.info("number of rows UPDATE COURSE SET last_updated_date=sysdate()  -> {}", executeUpdate);
	}

}
