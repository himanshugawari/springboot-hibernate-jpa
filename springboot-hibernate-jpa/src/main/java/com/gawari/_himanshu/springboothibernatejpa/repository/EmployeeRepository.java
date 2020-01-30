package com.gawari._himanshu.springboothibernatejpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gawari._himanshu.springboothibernatejpa.SpringbootHibernateJpaApplication;
import com.gawari._himanshu.springboothibernatejpa.entity.Employee;
import com.gawari._himanshu.springboothibernatejpa.entity.FullTimeEmployee;
import com.gawari._himanshu.springboothibernatejpa.entity.PartTimeEmployee;

@SuppressWarnings("unused")
@Repository
@Transactional
public class EmployeeRepository {

	private Logger log = LoggerFactory.getLogger(SpringbootHibernateJpaApplication.class);

	@Autowired
	EntityManager entityManager;

	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	public List<Employee> retrieveAllEmployees() {
		return entityManager.createQuery("Select e From Employee e", Employee.class).getResultList();
	}

	public Employee findById(Long id) {
		return entityManager.find(Employee.class, id);
	}

	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return entityManager.createQuery("Select e From PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return entityManager.createQuery("Select e From FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}
