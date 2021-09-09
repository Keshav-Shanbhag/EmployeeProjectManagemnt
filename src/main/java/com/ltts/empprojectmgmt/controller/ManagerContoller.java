package com.ltts.empprojectmgmt.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
public class ManagerContoller {
	
	@Autowired
	EmployeeBO eb;
	
	@Autowired
	ProjectBO pb;
	
	@Autowired
	DepartmentBO db;
	
	@Autowired
	WorksonBO wb;
	
	@RequestMapping("/addemp")
	public ModelAndView m1(@RequestParam int superid,@RequestParam int dnumber,Model model) {
		ModelAndView mv= new ModelAndView("addEmployee");
		model.addAttribute("dnumber", dnumber);
		model.addAttribute("superid", superid);
		Department d=db.getDeptNameByID(dnumber);
		model.addAttribute("deptname", d.getDname());
		return mv;
	}
	@RequestMapping("/addproject")
	public ModelAndView m2(@RequestParam int dnumber,@RequestParam int superid,Model model) {
		ModelAndView mv= new ModelAndView("addProject");
		model.addAttribute("dnumber", dnumber);
		Department d=db.getDeptNameByID(dnumber);
		model.addAttribute("deptname", d.getDname());
		model.addAttribute("superid", superid);
		return mv;
	}
	
	@RequestMapping(value="insertemployee",method=RequestMethod.POST)
	public ModelAndView m3(Model model,HttpServletRequest request)
	{
		int eid=Integer.parseInt(request.getParameter("eid"));
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String designation=request.getParameter("designation");
		String sex=request.getParameter("sex");
		int deptid=Integer.parseInt(request.getParameter("dnumber"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int super_id=Integer.parseInt(request.getParameter("superid"));
		
		Employee e1=new Employee(eid, email,password,fname,mname, lname,null,null,sex,null,designation,deptid, super_id);
		boolean b=eb.insertEmployee(e1);
		if(b==false)
		{
			model.addAttribute("msg", "Inserted Successfully");
			model.addAttribute("superid", super_id);
			return new ModelAndView("addEmployee");
		}
		else
		{
			model.addAttribute("msg", "Not Inserted");
			model.addAttribute("superid", super_id);
			return new ModelAndView("addEmployee");
		}
		
	}
	
	@RequestMapping(value="insertproject",method=RequestMethod.POST)
	public ModelAndView m4(Model model,HttpServletRequest request)
	{
		int superid=Integer.parseInt(request.getParameter("superid"));
		int pnumber=Integer.parseInt(request.getParameter("pnumber"));
		String pname=request.getParameter("pname");
		
		int deptid=Integer.parseInt(request.getParameter("dnumber"));
		
		LocalDate startDate=LocalDate.parse(request.getParameter("startdate"));
		LocalDate endDate=LocalDate.parse(request.getParameter("enddate"));
		
		Project p1=new Project(pnumber,pname,deptid,startDate,endDate);
		System.out.println(p1);
		boolean b=pb.insertProject(p1);
		if(b==false)
		{
			model.addAttribute("msg", "Project Inserted Successfully");
			model.addAttribute("superid", superid);
			return new ModelAndView("addProject");
		}
		else
		{
			model.addAttribute("msg", "Project Not Inserted");
			model.addAttribute("superid", superid);
			return new ModelAndView("addProject");
		}
		
	}
	@RequestMapping("/Managermain")
	public ModelAndView m5() {
		return new ModelAndView("Managermain");
	}
	@RequestMapping("/addDepartment")
	public ModelAndView m6(@RequestParam int superid,Model model) {
		ModelAndView mv= new ModelAndView("addDepartment");
		model.addAttribute("superid",superid);
		return mv;
	}
	@RequestMapping(value="insertdepartment",method=RequestMethod.POST)
	public ModelAndView m7(Model model,HttpServletRequest request)
	{
		int superid=Integer.parseInt(request.getParameter("superid"));
		int dnumber=Integer.parseInt(request.getParameter("dnumber"));
		String dname=request.getParameter("dname");
		String dlocation=request.getParameter("dlocation");
		int mgr_id=Integer.parseInt(request.getParameter("mgr_id"));
		
		
		Department d1=new Department(dnumber,dname,mgr_id,dlocation);
		
		boolean b=db.insertDepartment(d1);
		if(b==false)
		{
			model.addAttribute("msg", "Department Inserted Successfully");
			model.addAttribute("superid", superid);
			return new ModelAndView("addDepartment");
		}
		else
		{
			model.addAttribute("msg", "Department Not Inserted");
			model.addAttribute("superid", superid);
			return new ModelAndView("addDepartment");
		}
		
	}
	@RequestMapping("/addworkson")
	public ModelAndView m8(@RequestParam int dnumber,@RequestParam int superid,Model model) {
		ModelAndView mv= new ModelAndView("addWorkson");
		List<Project> plist=pb.getProjectByDnum(dnumber);
		List<Employee> elist=eb.getEmployeesByDnum(dnumber);
		model.addAttribute("plist", plist);
		model.addAttribute("elist", elist);
		Department d=db.getDeptNameByID(dnumber);
		model.addAttribute("deptname", d.getDname());
		model.addAttribute("superid", superid);
		return mv;
	}
	@RequestMapping(value="insertworkson",method=RequestMethod.POST)
	public ModelAndView m9(Model model,HttpServletRequest request)
	{
		int superid=Integer.parseInt(request.getParameter("superid"));
		int workid=Integer.parseInt(request.getParameter("workid"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		
		Workson w1=new Workson(workid,eid, pid,0);
		
		
		
		boolean b=wb.insertWorksOn(w1);
		if(b==false)
		{
			model.addAttribute("msg", "Project Assigned Successfully");
			model.addAttribute("superid", superid);
			return new ModelAndView("addWorkson");
		}
		else
		{
			model.addAttribute("msg", "Project Not Assigned");
			model.addAttribute("superid", superid);
			return new ModelAndView("addWorkson");
		}
		
	}
	@RequestMapping("/displayWorkson")
	public ModelAndView m10(@RequestParam int pid,@RequestParam int superid,Model model) {
		ModelAndView mv= new ModelAndView("DisplayWorksOn");
		List<Workson> wlist=wb.getWorksonByProjectID(pid);
		model.addAttribute("pid", pid);
		model.addAttribute("wlist", wlist);
		model.addAttribute("superid", superid);
		return mv;
	}
	@RequestMapping("/viewemployees")
	public ModelAndView m11(@RequestParam int superid,@RequestParam int dnumber,Model model) {
		ModelAndView mv= new ModelAndView("viewEmployees");
		Department d=db.getDeptNameByID(dnumber);
		model.addAttribute("deptname",d.getDname());
		Employee m1=eb.checkEmployeeByID(superid);
		String fullname=m1.getFname()+" "+m1.getMname()+" "+m1.getLname();
		model.addAttribute("manager_name",fullname);
		List<Employee> elist=eb.getEmployeeList(superid,dnumber);
		model.addAttribute("elist",elist);
		model.addAttribute("superid", superid);
		return mv;
	}
	@RequestMapping("/backtomanagermain")
	public ModelAndView m12(@RequestParam int empid,Model model) {
		ModelAndView mv= new ModelAndView("Managermain");
		Employee e=eb.checkEmployeeByID(empid);
		model.addAttribute("managerid", e.getEmpid());
		String fullname=e.getFname()+" "+e.getMname()+" "+e.getLname();
		model.addAttribute("managername",fullname);
		Department d=db.getDeptNameByID(e.getDno());
		model.addAttribute("deptname",d.getDname());
		model.addAttribute("dnum",e.getDno());
		
		List<Project> plist=pb.getProjectByDnum(e.getDno());
		model.addAttribute("plist",plist);
		return mv;
	}
}
