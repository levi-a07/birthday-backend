package com.example.birthday.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.birthday.Service.BirthdayService;
import com.example.birthday.dto.Employee;
import com.example.birthday.dto.UserLogin;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.spring.web.json.Json;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class birthdayController {

	@Autowired
	BirthdayService bService;

	@ApiResponses(value = { @ApiResponse(code = 201, message = "emp created sucessfully") })
	@PostMapping(value = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean registerEmp(@RequestBody Employee emp) {

		return bService.registerEmp(emp);
	}
	
	@ApiResponses(value = { @ApiResponse(code = 201, message = " login sucessful") })
	@PostMapping(value = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public UserLogin LoginEmp(@RequestBody  String empJson ) {
System.out.println(bService.loginEmp(empJson));
		return bService.loginEmp(empJson);
		
	}
	

	@ApiResponses(value = { @ApiResponse(code = 201, message = "emp fetched sucessfully") })
	@GetMapping(value = "/emp/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee readEmp(@PathVariable Integer id) {

		return bService.readEmp(id);
	}

	@ApiResponses(value = { @ApiResponse(code = 201, message = "updated sucessfully") })
	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Employee UpdateEmp(@RequestBody Employee emp, @PathVariable Integer id) {
		return bService.UpdateEmp(id, emp);

	}

	@ApiResponses(value = { @ApiResponse(code = 201, message = " deleted sucessfully") })
	@DeleteMapping(value = "/admin",
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public Boolean deleteEmp(@RequestParam Integer id) {
		
		System.out.println("test");
		return bService.deleteEmp(id);
	}

	// admin priviledges
	@ApiResponses(value = { @ApiResponse(code = 201, message = "all emp fetched sucessfully") })
	@GetMapping(value = "/admin/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> ReadEmps() {
		System.out.println("/n /n /n admin read /n /n /n");
		return bService.reademps();
	}

	@ApiResponses(value = { @ApiResponse(code = 201, message = "added emp to team sucessfully") })
	@PutMapping(value= "/adminedit")
	public Boolean addEmpToTeam(@RequestBody String empJson) {

        JSONObject obj = new JSONObject(empJson);

        Integer emp_id = Integer.valueOf(obj.getInt("emp_id"));

        Integer team_id = Integer.valueOf(obj.getInt("team_id"));

System.out.println(emp_id);
		return bService.addEmpToTeam(emp_id, team_id);
	}

	@ApiResponses(value = { @ApiResponse(code = 201, message = "emp deleted from team sucessfully") })
	@DeleteMapping(value = "/admin/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean deleteEmpfromTeam(@PathVariable Integer emp_id) {
		return bService.deleteEmpfromTeam(emp_id);
	}


//	@Scheduled(fixedRate = 5000)
		public List<Employee> getEmpBymonth() {
		 int month=LocalDate.now().getMonthValue();
		 
	   return bService.getAllEmployeeByMonth(month);
	  }
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Employee> getEmpBymonth() {
//		int month = LocalDate.now().getMonthValue();
//
//		return bService.getAllEmployeeByMonth(month);
//	}
//
	@RequestMapping(value = "/empBydate", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmpByDate() {
		
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
		return bService.getAllEmployeeByDate();
	}
	
}
