package com.Practices.CRUDMaven.dao;

import java.util.List;

import com.Practices.CRUDMaven.entity.Employee;

public interface EmployeeDao {

	// to find all the list from employee
	public List<Employee> findAll();

	// to find single the list from employee
	public Employee findById(int id);

	// save and update(add one more obj
	public void saveOrUpdate(Employee emp);

	// delete the obj //so all 4 method is CRUD operation
	public void deleteById(int id);
}
