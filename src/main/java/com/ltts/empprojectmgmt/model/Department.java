package com.ltts.empprojectmgmt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	private int dnumber;
	private String dname;
	private int mgr_id;
	private String dlocation;
	public int getDnumber() {
		return dnumber;
	}
	public void setDnumber(int dnumber) {
		this.dnumber = dnumber;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getDlocation() {
		return dlocation;
	}
	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}
	public Department(int dnumber, String dname, int mgr_id, String dlocation) {
		super();
		this.dnumber = dnumber;
		this.dname = dname;
		this.mgr_id = mgr_id;
		this.dlocation = dlocation;
	}
	public Department() {
		super();
	}
	
	
	
	
}
