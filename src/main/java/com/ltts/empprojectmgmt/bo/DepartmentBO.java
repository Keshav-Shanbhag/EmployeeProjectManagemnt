package com.ltts.empprojectmgmt.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.empprojectmgmt.model.Department;
import com.ltts.empprojectmgmt.model.Employee;

@Repository
public class DepartmentBO {

	
	@Autowired
	SessionFactory sf;

	public boolean insertDepartment(Department d1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		
		s.save(d1);
		s.getTransaction().commit();
		
		s.close();
		return false;
	}

	public Department getDeptNameByID(int dno) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		Department d=(Department)s.load(Department.class,dno);
		s.getTransaction().commit();
		return d;
		
	}
}
