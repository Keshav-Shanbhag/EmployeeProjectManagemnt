package com.ltts.empprojectmgmt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Employee {

	@Id
	private int empid;
	private String email;
	private String password;
	private String fname;
	private String mname;
	private String lname;
	private LocalDate dob;
	private String address;
	private String sex;
	private String phonenum;
	private String designation;
	private int dno;
	private int super_id;
	private byte[] photo;
	
	public byte[] getPhoto() {
        return photo;
    }
 
    public void setPhoto(byte[] photo) {
        this.photo= photo;
    }
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getSuper_id() {
		return super_id;
	}
	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}
	public Employee(int empid, String email, String password, String fname, String mname, String lname, LocalDate dob,
			String address, String sex, String phonenum, String designation, int dno, int super_id) {
		super();
		this.empid = empid;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.dob = dob;
		this.address = address;
		this.sex = sex;
		this.phonenum = phonenum;
		this.designation = designation;
		this.dno = dno;
		this.super_id = super_id;
	}
	public Employee() {
		super();
	}
	
	
}
