package com.example.birthday.dto;

public class UserLogin {


private String emp_name;
private Integer team_id;
private String role;
public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public Integer getTeam_id() {
	return team_id;
}
public void setTeam_id(Integer team_id) {
	this.team_id = team_id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "UserLogin [emp_name=" + emp_name + ", team_id=" + team_id + ", role=" + role + "]";
}
	
}
