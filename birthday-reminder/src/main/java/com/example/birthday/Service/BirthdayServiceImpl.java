package com.example.birthday.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.xml.crypto.Data;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.birthday.dto.Employee;
import com.example.birthday.dto.UserLogin;
import com.example.birthday.repositories.BirthdayRepository;

@Service
public class BirthdayServiceImpl implements BirthdayService {

	@Autowired
	BirthdayRepository birthdayRepository;

	@Override
	public Boolean registerEmp(Employee emp) {
		
		System.out.println(emp);
		System.out.println("/n /n /n hghgfhfg\n " + emp.getDob() + "/n /n /n /n ");
		Optional<Employee> current = birthdayRepository.findById(emp.getEmp_id());
		
		if (current.isPresent()) {
			return false;

		} else {
			DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate lddob = LocalDate.parse(emp.getDob().toString(), sdf);
			emp.setDob(lddob);
			System.out.print(emp.getDob());
			birthdayRepository.save(emp);
			return true;
		}
	}

	@Override
	public Employee readEmp(Integer emp_id) {
		Optional<Employee> current = birthdayRepository.findById(emp_id);
		if (current.isPresent()) {

			System.out.println(" /n /n /n \n \n ");
			System.out.println(birthdayRepository.findAllByMonth(11));
			return current.get();

		}
		throw new RuntimeException("employee is not found for the id  " + emp_id);

	}

	@Override
	public Employee UpdateEmp(Integer emp_id, Employee emp) {
		Optional<Employee> current = birthdayRepository.findById(emp_id);
		if (current.isPresent()) {
			emp.setEmp_id(emp_id);
			return birthdayRepository.save(emp);
		}
		throw new RuntimeException("employee is not found for the id  " + emp_id);

	}

	@Override
	public Boolean deleteEmp(Integer emp_id) {

		System.out.println("deleting employe /n /n " + emp_id);

		Optional<Employee> current = birthdayRepository.findById(emp_id);
		if (current.isPresent()) {
			System.out.println("deleted employe /n /n " + emp_id);
			birthdayRepository.deleteById(emp_id);
			System.out.println("successull");
			return true;
		} else {
			System.out.println("akdskjd");
			return false;
		}
	}

	@Override
	public List<Employee> reademps() {
		return birthdayRepository.findAll();
	}

	@Override
    public Boolean addEmpToTeam(int emp_id, int team_no) {
        Optional<Employee> current = birthdayRepository.findById(emp_id);
        if (current.isPresent()) {
            Employee emp = current.get();
            emp.setTeam_id(team_no);
            birthdayRepository.save(emp);
            return true;
        }
        throw new RuntimeException("employee is not found for the id  " + emp_id);

    }


	@Override
	public Boolean deleteEmpfromTeam(Integer emp_id) {
		Optional<Employee> current = birthdayRepository.findById(emp_id);
		if (current.isPresent()) {
			Employee emp = current.get();
			emp.setTeam_id(0);
			birthdayRepository.save(emp);
			return true;
		}
		throw new RuntimeException("employee is not found for the id  " + emp_id);

	}

	@Override
	public List<Employee> getAllEmployeeByMonth(int month) {

//		birthdayRepository.findAllByMonth(month);
//		

		return birthdayRepository.findAllByMonth(month);
	}

	@Override
	public UserLogin loginEmp(String empjson) {

		UserLogin userLogin = new UserLogin();
		JSONObject obj = new JSONObject(empjson);
		String password = obj.getString("password");
		int emp_id = obj.getInt("emp_id");

		Optional<Employee> current = birthdayRepository.findById(emp_id);
		if (current.isPresent()) {

			System.out.println(current.get().getDob());

			System.out.println("\n\n \n user  " + password);
			if (password.equals(current.get().getPassword())) {

				userLogin.setEmp_name(current.get().getEmp_name());
				userLogin.setRole(current.get().getRole());
				userLogin.setTeam_id(current.get().getTeam_id());

				return userLogin;
			} else {

				System.out.println("testing55");
				return null;
			}

		}

		return null;
	}

	@Override
	public List<Employee> getAllEmployeeByDate() {

		LocalDate bdate = LocalDate.now();
		int month = bdate.getMonthValue();
		int day = bdate.getDayOfMonth();
		System.out.println(month);
		System.out.println(day);

		System.out.println(birthdayRepository.findAllByDateEmp(day, month));
		System.out.println("works right till here");
		return birthdayRepository.findAllByDateEmp(day, month);

	}

}
