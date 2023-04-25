package com.example.birthday.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;


@Builder
@Entity
public class Employee {
	
@Id 
private Integer emp_id;
private String emp_name;
private String username;
private Integer team_id;
private String password;
private String role;


////@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
//@JsonSerialize(using = OffsetDateTimeSerializer.class) 
//@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate dob;



public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}


public Integer getEmp_id() {
	return emp_id;
}
public void setEmp_id(Integer emp_id) {
	this.emp_id = emp_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Integer  getTeam_id() {
	return team_id;
}
public void setTeam_id(Integer i) {
	this.team_id = i;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;

	
	
	
}
@Override
public String toString() {
	return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", username=" + username + ", team_id=" + team_id
			+ ", password=" + password + ", role=" + role + ", dob=" + dob + "]";
}
public Employee() {
	super();
}
public Employee(Integer emp_id, String emp_name, String username, Integer team_id, String password, String role,
		LocalDate dob) {
	super();
	this.emp_id = emp_id;
	this.emp_name = emp_name;
	this.username = username;
	this.team_id = team_id;
	this.password = password;
	this.role = role;
	this.dob = dob;
}
	
}


