package com.ltts.empprojectmgmt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {

	
	@Id
	private int pnumber;
	private String pname;
	private int dnum;
	private LocalDate startDate;
	private LocalDate endDate;
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Project(int pnumber, String pname, int dnum, LocalDate startDate, LocalDate endDate) {
		super();
		this.pnumber = pnumber;
		this.pname = pname;
		this.dnum = dnum;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Project() {
		super();
	}
	@Override
	public String toString() {
		return "Project [pnumber=" + pnumber + ", pname=" + pname + ", dnum=" + dnum + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
