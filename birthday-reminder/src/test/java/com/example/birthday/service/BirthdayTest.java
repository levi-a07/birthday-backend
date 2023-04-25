package com.example.birthday.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.birthday.dto.Employee;
import com.example.birthday.repositories.BirthdayRepository;


@ExtendWith(MockitoExtension.class)
class BirthdayTest {
	@Mock
	private BirthdayRepository birthdayRepository;
	
	private Employee employee;

	@BeforeEach
	public void setup() {

		employee = Employee.builder().dob(LocalDate.of(2002, 2, 2)).team_id(1).emp_name("jane").emp_id(1001)
				.username("test@gmail.com").password("waes").role("admin").build();

	}

	@Test
	void testRegisterEmp() {
		birthdayRepository.save(employee);
		assertThat(employee.getEmp_name()).isEqualTo("jane");
	}

	@Test
	void testReadEmp() {

		Employee emp = birthdayRepository.findById(1001).get();
		assertThat(emp.getEmp_id()).isEqualTo(1001);
	}

	@Test
	void testUpdateEmp() {

		Employee emp = birthdayRepository.findById(1001).get();
		emp.setEmp_name("Cena");
		Employee newEmp=birthdayRepository.save(emp);
		assertThat(newEmp.getEmp_name()).isEqualTo("Cena");
		
	}

	@Test
	void testDeleteEmp() {
		Employee emp=birthdayRepository.findById(1001).get();
		
		birthdayRepository.delete(emp);
		Employee emp1=null;
		Optional<Employee> optionalEmp=birthdayRepository.findById(1001);
		if(optionalEmp.isPresent()) {
			emp1=optionalEmp.get();
		}
		assertThat(emp1).isNull();
			
		
	}

	@Test
	void testReademps() {
		List<Employee> emps = birthdayRepository.findAll();
		
		assertThat(emps.size()).isGreaterThan(0);
	}

}
