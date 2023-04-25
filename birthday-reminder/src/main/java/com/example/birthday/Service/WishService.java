package com.example.birthday.Service;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.example.birthday.dto.BirthdayWish;
import com.example.birthday.dto.Employee;

public interface WishService {
	//
	
	//wish on comments
	
	 List<BirthdayWish> getWishesbyBdayEmpId(Integer id);

	Boolean saveWish(BirthdayWish wish);

	Boolean sendMail(List<Employee> birthdaysOfEmps) throws AddressException, MessagingException, IOException;
	
}
