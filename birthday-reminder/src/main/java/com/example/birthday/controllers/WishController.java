package com.example.birthday.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.birthday.Service.BirthdayService;
import com.example.birthday.Service.WishService;
import com.example.birthday.dto.BirthdayWish;
import com.example.birthday.dto.Employee;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/wish/")
public class WishController {

	@Autowired
	WishService wService;
	@Autowired
	BirthdayService bservice;
	

	@ApiResponses(value = { @ApiResponse(code = 201, message = "emp created sucessfully") })
	@PostMapping(value = "/saveWish", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean saveWish(@RequestBody BirthdayWish wish) {
				wish.setCreatedOn(LocalDateTime.now());
		return wService.saveWish(wish);
	}
	

    @ApiResponses(value = {@ApiResponse(code = 201, message = "emp created sucessfully")})
    @GetMapping(value = "/getwish")
    public List<BirthdayWish> getWishesbyBdayEmpId() {
        return wService.getWishesbyBdayEmpId(1);

    }


    @Scheduled(fixedRate = 1000000000)
    public Boolean sendMail() throws AddressException, MessagingException, IOException {
        List<Employee> birthdaysOfEmps = bservice.getAllEmployeeByDate();
        System.out.println("/n  WSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDTTTTTTTTTTTTTTTTTTTTTTTTTTTT ");
        System.out.println(birthdaysOfEmps);
        return wService.sendMail(birthdaysOfEmps);

    }


}
