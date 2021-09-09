package com.ltts.empprojectmgmt.bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.empprojectmgmt.model.Employee;
import com.ltts.empprojectmgmt.model.Project;

@Repository
public class EmployeeBO {

	@Autowired
	SessionFactory sf;
	
	public Employee checkEmployeeByID(int empid) {
		//User u=null;
		Session s=sf.openSession();
		s.beginTransaction();
		Employee e=(Employee) s.load(Employee.class,empid);
		s.getTransaction().commit();
		return e;
	}

	public boolean insertEmployee(Employee e1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		
		s.save(e1);
		s.getTransaction().commit();
		
		s.close();
		return false;
		
	}
	public List<Employee> getEmployeesByDnum(int dnumber)
	{
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Employee> q=s.createQuery("FROM Employee where dno=:dno AND designation <>:empdesign");
		q.setParameter("dno",dnumber);
		q.setParameter("empdesign","Manager");
		List<Employee> employees=q.list();
		tx.commit();
		s.close();
		return employees;
	}

	public boolean updateEmployee(Employee e1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
	    s.beginTransaction();
	    s.saveOrUpdate(e1);
	   
	    s.getTransaction().commit();
	    s.close();
		return false;
	}

	public List<Employee> getEmployeeList(int superid, int dnumber) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Employee> q=s.createQuery("FROM Employee where dno=:dno AND super_id=:superid");
		q.setParameter("dno",dnumber);
		q.setParameter("superid",superid);
		List<Employee> employees=q.list();
		tx.commit();
		s.close();
		return employees;
	
	}
}
