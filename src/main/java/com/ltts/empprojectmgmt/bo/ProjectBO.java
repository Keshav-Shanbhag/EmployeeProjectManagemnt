package com.ltts.empprojectmgmt.bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.empprojectmgmt.model.Project;

@Repository
public class ProjectBO {

	@Autowired
	SessionFactory sf;

	public boolean insertProject(Project p1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		
		s.save(p1);
		s.getTransaction().commit();
		
		s.close();
		return false;
		
	}
	public List<Project> getProjectByDnum(int dnumber)
	{
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Project> q=s.createQuery("FROM Project where dnum=:dnumber");
		q.setParameter("dnumber",dnumber);  
		List<Project> projects=q.list();
		tx.commit();
		s.close();
		return projects;
	}

	
}
