
# Employee’s Project Management System

* This system gives a brief picture about employees working in a company under different departments.
* Each Department has certain Projects which are handled by Employees of that Department.
* Each Department is handled by a Single Manager under him that department's Employees are working.

## High Level Requirements:
* Manager should able to Retrieve Details of Projects handled by Employees under him.
* Retrieve Employees details working in Department handled by a manager.
* Employee Updates Hours of Work on Each Projects worked.
## Low Level Requirements:
* Manager is responsible to add new department & new projects under that department.
* Manager cann Assign a Project to a Employee.
* Manager can see various Projects Under Department.
* Manager can see how many employess have logged how many hours on each Project.
* Employee is able to edit Password and his personal details
* Manager can add employee under his department by assigning USER ID,Email,Password.
* USER ID and Email ID cannot be edited by Employee Assigned by Manager.
* Manager can only view all Projects and Logged Hours by each Employee.
* Individual Employee Cannot see others Logged Hours.

## Research & Literature Review:
* According to our research, 33% of companies say that the most important feature of a project management tool is its ability to handle complex projects. 27% of companies think that a project management tool is great for predicting incoming problems, while 8% of them say that the ability of a project management tool to track budgets and billable hours is its most important feature.

* Jira is an agile project management software that is typically used by software development teams to plan, build, track and release products. This system streamlines the development process from the conceptualization phase through to the actualization phase.
* GanttPRO is a project management solution that uses Gantt Charts to help team members become more productive and efficient in managing their workloads, from the conceptualization phase to the actualization and delivery phases. GanttPRO is designed with the objective of improving communication and collaboration, simplifying workflows, and monitoring the progress of projects. 


## Design-Class Diagram

![Class Diagram](https://github.com/Keshav-Shanbhag/EmployeeProjectManagemnt/blob/main/Class%20Diagram.jpg)

## Implementation
* System was developed using Spring MVC with hibernate pages shows data to the front end which stored in database. We developed login page to login both employee and manager.
* Once login with right credentials system finds whether logged in user is either employee or manager and will take to their respective window.
* Once Manager log in, he can see projects under his department which he is undertaking. 
* He can see individual contribution of each employee who are assigned to that particular project. 
* He can also add new project to the department and can assign employee to that project. He can also add new employee to his department.
* On other part, when Employee once log in is finished, he can see home page where project details assigned to him is available to him.
* He can update hours of work he logged for that project. He can also update his profile .

## Project Overview
(https://github.com/Keshav-Shanbhag/EmployeeProjectManagemnt/blob/main/Project%20Overview.mp4)

## Test Cases:

|  **Test ID**   |   **Description**  |	  **Results**   |
|----------------|--------------------|-----------------|
|1|	Password Validation	|Implemented|
|2	|Employee Hours Updation	|Implemented|
|3	|Employee Cannot Change Email,Employee ID |	Implemented|
|4	|Manager can only view all Projects under that department|	Implemented|



**Video Summary**
* https://github.com/Keshav-Shanbhag/EmployeeProjectManagemnt/blob/main/Project%20Overview.mp4



**Git Link**
 * https://github.com/Keshav-Shanbhag/EmployeeProjectManagemnt

## Summary
* This system helps manager to keep track of all projects and know who all employees have logged their efforts in hours.
* Employee can have track of work records and know about deadlines and work before that date.
* Manager can check all status of employees and day by day progress can also be viewed.




## Future Scope 
* Project related queries and workflow can be shared and stored among all employees working on that department.
* Employee can request for particular project and Manager can assign similar projects based on history of working of that employee.
* Employee can restrict to the maximum of project assigned to him in same duration.

