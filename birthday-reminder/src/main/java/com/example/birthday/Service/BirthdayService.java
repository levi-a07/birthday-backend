package com.example.birthday.Service;

import java.util.List;

import com.example.birthday.dto.Employee;
import com.example.birthday.dto.UserLogin;

public interface BirthdayService {
	//CRUD
	
	//for individual
	Boolean registerEmp(Employee emp);
	Employee readEmp(Integer Emp_id);
	Employee UpdateEmp(Integer Emp_id,Employee emp);
	Boolean deleteEmp(Integer Emp_id);
	
	//for admin + features
	List<Employee> reademps();
	Boolean deleteEmpfromTeam(Integer Emp_id);
	List<Employee> getAllEmployeeByMonth(int month);
	
	UserLogin loginEmp(String empJson);
	List<Employee> getAllEmployeeByDate();
	Boolean addEmpToTeam(int emp_id, int team_no);
	  
}
