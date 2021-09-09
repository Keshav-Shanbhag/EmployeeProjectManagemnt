package com.ltts.empprojectmgmt.bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.empprojectmgmt.model.Department;
import com.ltts.empprojectmgmt.model.Workson;

@Repository
public class WorksonBO {

	@Autowired
	SessionFactory sf;
	
	public boolean insertWorksOn(Workson w1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		
		s.save(w1);
		s.getTransaction().commit();
		
		s.close();
		return false;
	}
	public List<Workson> getWorksonByProjectID(int pid)
	{
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Workson> q=s.createQuery("FROM Workson where pno=:pnum");
		q.setParameter("pnum",pid);
		
		List<Workson> workson=q.list();
		tx.commit();
		s.close();
		return workson;
	}
	public List<Workson> getWorksonByEid(int empid) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Workson> q=s.createQuery("FROM Workson where eid=:empid");
		q.setParameter("empid",empid);
		
		List<Workson> workson=q.list();
		tx.commit();
		s.close();
		return workson;
	}
	public Workson getWorksonBYWorkId(int workid) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		s.beginTransaction();
		Workson w=(Workson)s.load(Workson.class,workid);
		s.getTransaction().commit();
		return w;
		
	}
	public boolean updateWorksOn(Workson w1) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
	    s.beginTransaction();
	    s.saveOrUpdate(w1);
	   
	    s.getTransaction().commit();
	    s.close();
		return false;
		
	}

}
