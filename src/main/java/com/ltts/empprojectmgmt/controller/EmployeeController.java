package com.ltts.empprojectmgmt.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.empprojectmgmt.bo.DepartmentBO;
import com.ltts.empprojectmgmt.bo.EmployeeBO;
import com.ltts.empprojectmgmt.bo.ProjectBO;
import com.ltts.empprojectmgmt.bo.WorksonBO;
import com.ltts.empprojectmgmt.model.Department;
import com.ltts.empprojectmgmt.model.Employee;
import com.ltts.empprojectmgmt.model.Project;
import com.ltts.empprojectmgmt.model.Workson;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeBO eb;
	
	@Autowired
	DepartmentBO db;
	
	@Autowired
	ProjectBO pb;
	
	@Autowired
	WorksonBO wb;
	
	@RequestMapping("/")
	public ModelAndView m1() {
		return new ModelAndView("index");
	}
	@RequestMapping("/index")
	public ModelAndView m2() {
		return new ModelAndView("index");
	}
	@RequestMapping(value="checkemp")
	public ModelAndView m3(HttpServletRequest request, Model model) {
		ModelAndView mv=null;
		int empid=Integer.parseInt(request.getParameter("empid"));
		
		String password=request.getParameter("password");
		
		 Employee e=eb.checkEmployeeByID(empid);
		
		if(e.equals(null)) {
			model.addAttribute("msg", "Your User Name is Wrong");
			mv=new ModelAndView("index");
		}
		else if(e.getEmpid()==empid) {
			if(e.getPassword().equals(password)) {
				
				if(e.getDesignation().equals("Manager")) {
					model.addAttribute("managerid", e.getEmpid());
					String fullname=e.getFname()+" "+e.getMname()+" "+e.getLname();
					model.addAttribute("managername",fullname);
					Department d=db.getDeptNameByID(e.getDno());
					model.addAttribute("deptname",d.getDname());
					model.addAttribute("dnum",e.getDno());
					
					List<Project> plist=pb.getProjectByDnum(e.getDno());
					model.addAttribute("plist",plist);
					mv=new ModelAndView("Managermain");
				}
				else
				{
					model.addAttribute("empid", e.getEmpid());
					String fullname=e.getFname()+" "+e.getMname()+" "+e.getLname();
					model.addAttribute("empname",fullname);
					Department d=db.getDeptNameByID(e.getDno());
					model.addAttribute("deptname",d.getDname());
					List<Workson> wonlist=wb.getWorksonByEid(e.getEmpid());
					model.addAttribute("wonlist",wonlist);
					mv=new ModelAndView("employeemain");
					
				}
			}
			else {
				model.addAttribute("msg", "Your password is wrong");
				mv=new ModelAndView("index");
			}
		}
		else {
			model.addAttribute("msg", "Your User Name is Wrong");
			mv=new ModelAndView("index");
		}
		return mv;
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView m4(@RequestParam int eid,Model model) {
		ModelAndView mv= new ModelAndView("updateEmployee");
		Employee e1=eb.checkEmployeeByID(eid);
		model.addAttribute("emp", e1);
		model.addAttribute("empid", eid);
		return mv;
	}
	@RequestMapping(value="updateemp",method=RequestMethod.POST)
	public ModelAndView m5(Model model,HttpServletRequest request,@RequestParam MultipartFile img) throws IOException
	{
		int eid=Integer.parseInt(request.getParameter("eid"));
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String designation=request.getParameter("designation");
		String sex=request.getParameter("sex");
		LocalDate dob=LocalDate.parse(request.getParameter("dob"));
		int deptid=Integer.parseInt(request.getParameter("dnumber"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int super_id=Integer.parseInt(request.getParameter("superid"));
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String filename = img.getOriginalFilename();  
		
		Employee e1=new Employee(eid,email,password,fname,mname,lname,dob,address,sex,phone,designation,deptid,super_id);
		//e1.setPhoto(img.getBytes());
		boolean b=eb.updateEmployee(e1);
		if(b==false)
		{
			model.addAttribute("msg", "Updated Successfully");
			model.addAttribute("empid",eid);
			
			return new ModelAndView("updateEmployee");
		}
		else
		{
			model.addAttribute("msg", "Update Failed");
			model.addAttribute("empid",eid);
			return new ModelAndView("updateEmployee");
		}
		
	}
	@RequestMapping("/updateWorkson")
	public ModelAndView m6(@RequestParam int Workid,@RequestParam int eid,Model model) {
		ModelAndView mv= new ModelAndView("UpdateHours");
		Workson w1=wb.getWorksonBYWorkId(Workid);
		model.addAttribute("w1", w1);
		model.addAttribute("empid", eid);
		return mv;
	}
	@RequestMapping(value="updateHours",method=RequestMethod.POST)
	public ModelAndView m7(Model model,HttpServletRequest request)
	{
		int workid=Integer.parseInt(request.getParameter("workid"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		int hours=Integer.parseInt(request.getParameter("hours"));
		
								
		Workson w1=new Workson(workid,eid, pid, hours);
		boolean b=wb.updateWorksOn(w1);
		if(b==false)
		{
			model.addAttribute("msg", "Updated Successfully");
			model.addAttribute("empid",eid);
			return new ModelAndView("UpdateHours");
		}
		else
		{
			model.addAttribute("msg", "Update Failed");
			model.addAttribute("empid",eid);
			return new ModelAndView("UpdateHours");
		}
		
	}
	@RequestMapping("/backtoempmain")
	public ModelAndView m8(@RequestParam int empid,Model model) {
		ModelAndView mv= new ModelAndView("employeemain");
		Employee e=eb.checkEmployeeByID(empid);
		model.addAttribute("empid", e.getEmpid());
		String fullname=e.getFname()+" "+e.getMname()+" "+e.getLname();
		model.addAttribute("empname",fullname);
		Department d=db.getDeptNameByID(e.getDno());
		model.addAttribute("deptname",d.getDname());
		List<Workson> wonlist=wb.getWorksonByEid(e.getEmpid());
		model.addAttribute("wonlist",wonlist);
		return mv;
	}
	
	
}
