package com.example.java7;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Person {
		
	public enum Sex {
		MALE, FEMALE;
	}
	
	private String name;
	private Date birthday;
	private Sex gender;
	private String emailAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public int getCurrentAge() {
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(getBirthday());
		LocalDate birthDate = LocalDate.of(birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH)+1,				
				birthday.get(Calendar.DAY_OF_MONTH));
		LocalDate today = LocalDate.now();
		return Period.between(birthDate, today).getYears();
	}
	
	public String printPerson() {
		StringBuilder personDetail = new StringBuilder(this.name);
		personDetail.append(this.getGender().name()).append(getEmailAddress());
		System.out.println(personDetail + "<===>+" +getBirthday().toString() + "<===>" +this.getCurrentAge());
		return personDetail.toString();
	}

}
