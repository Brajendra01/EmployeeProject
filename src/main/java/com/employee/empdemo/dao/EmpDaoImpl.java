package com.employee.empdemo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.empdemo.enity.Employee;

@Transactional
@Repository
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmp(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
	
	

}
