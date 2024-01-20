package com.Practices.CRUDMaven.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Practices.CRUDMaven.entity.Employee;
import org.hibernate.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;



@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    
	EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query query=currentSession.createQuery("From Employee");
		List<Employee> emp=query.getResultList();
		return emp;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employee=currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Employee emp) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(currentSession);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employee =findById(id);
		currentSession.delete(employee);
		
	}

	
}
