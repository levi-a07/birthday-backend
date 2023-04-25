package com.example.birthday.dto;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BirthdayWish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wish_id;

@ManyToOne()
@JoinColumn(name = "sender_emp_id",referencedColumnName = "emp_id")
	private Employee sender;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	  @JoinColumn(name = "recievers_emp_id", nullable = false)
//	  @OnDelete(action = OnDeleteAction.CASCADE)
//  @JsonIgnore

@ManyToOne()

@JoinColumn(name = "reciever_emp_id",referencedColumnName = "emp_id")
	private Employee reciever;
	
	
	@Lob
	private String wish_text;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime createdOn;

	public Integer getWish_id() {
		return wish_id;
	}

	public void setWish_id(Integer wish_id) {
		this.wish_id = wish_id;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public Employee getReciever() {
		return reciever;
	}

	public void setReciever(Employee reciever) {
		this.reciever = reciever;
	}

	public String getWish_text() {
		return wish_text;
	}

	public void setWish_text(String wish_text) {
		this.wish_text = wish_text;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	


	
	
	
}
