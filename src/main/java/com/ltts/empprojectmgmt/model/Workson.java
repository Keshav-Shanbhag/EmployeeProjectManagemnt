package com.ltts.empprojectmgmt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Workson {
	@Id
	private int workid;
	private int eid;
	private int pno;
	private int hours;
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public Workson(int workid, int eid, int pno, int hours) {
		super();
		this.workid = workid;
		this.eid = eid;
		this.pno = pno;
		this.hours = hours;
	}
	public Workson() {
		super();
	}
	
}
