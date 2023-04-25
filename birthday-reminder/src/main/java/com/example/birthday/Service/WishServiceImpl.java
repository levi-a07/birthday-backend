package com.example.birthday.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.birthday.dto.BirthdayWish;
import com.example.birthday.dto.Employee;
import com.example.birthday.repositories.BirthdayRepository;
import com.example.birthday.repositories.BirthdayWishRepository;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	BirthdayWishRepository wishRepository;
	@Autowired
	BirthdayRepository employeeRepository;

	@Override
	public List<BirthdayWish> getWishesbyBdayEmpId(Integer id) {
		return wishRepository.findByRecieverId(id);
	}

	@Override
	public Boolean saveWish(BirthdayWish wish) {
		wishRepository.save(wish);
		return true;

	}

	@Override
	public Boolean sendMail(List<Employee> birthdaysOfEmps) throws AddressException, MessagingException, IOException {
		if (birthdaysOfEmps.size() > 0) {
			for (Employee emp : birthdaysOfEmps) {
				System.out.println(emp.getEmp_id());

				String emailBody = "Happy Birthay!! " + emp.getEmp_name().toUpperCase();
				List<BirthdayWish> bdayEmployeeWishes = wishRepository.findByRecieverId(emp.getEmp_id());
				if (bdayEmployeeWishes.size() > 0) {
					for (BirthdayWish wish : bdayEmployeeWishes) {

						String sent_by = wish.getSender().getEmp_name();
						String wish_text = wish.getWish_text();

						emailBody = emailBody + "\n\n \n  Sent By  : " + sent_by + " \n  " + wish_text + "\n";
						wishRepository.delete(wish);
					}

				}
			sendbdayWishes(emailBody, emp.getUsername());

				System.out.println("above  MAIL " + emailBody + emp.getEmp_id());
			}
			return true;
		}
		System.out.println("\n \n :) ;) \n could not sent no birthdays");
		return false;
	}

	private void sendbdayWishes(String emailBody, String reciever_mail_id)
			throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("anandache.laxmi96@gmail.com", "xtuznehxqbvqxinj");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("noreply@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever_mail_id));
		msg.setSubject("Happy Birthday!!");

		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();

		messageBodyPart.setContent(emailBody, "text/plain");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);

		System.out.println("sending email-->");
		Transport.send(msg);
	}

}
