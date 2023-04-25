package com.example.birthday.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.birthday.dto.Employee;

@Repository
public interface BirthdayRepository extends JpaRepository<Employee, Integer> {

	 List<Employee> findByDob(LocalDate cal_date);

	    @Query(
	            name = "Employee.findAllByMonth",
	            value = "SELECT E FROM Employee E WHERE MONTH(E.dob) = :monthValue"
	    )
	    List<Employee> findAllByMonth(@Param("monthValue") Integer monthValue);

	    @Query(name = "Employee.findAllByDateEmp",
	            value = "select e from Employee e where day(e.dob) = ?1 and month(e.dob) = ?2")
	    List<Employee> findAllByDateEmp(int day, int month);


	}
