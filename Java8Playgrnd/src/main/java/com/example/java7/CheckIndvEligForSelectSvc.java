package com.example.java7;

import java.util.Calendar;

import com.example.java7.Person.Sex;

public class CheckIndvEligForSelectSvc implements CheckPerson {
	
	private Integer minEligAge;
	private Integer maxEligAge;
	private Sex eligGender;

	
	public Integer getMinEligAge() {
		return minEligAge;
	}

	public void setMinEligAge(Integer minEligAge) {
		this.minEligAge = minEligAge;
	}

	public Integer getMaxEligAge() {
		return maxEligAge;
	}

	public void setMaxEligAge(Integer maxEligAge) {
		this.maxEligAge = maxEligAge;
	}

	public Sex getEligGender() {
		return eligGender;
	}

	public void setEligGender(Sex eligGender) {
		this.eligGender = eligGender;
	}

	@Override
	public boolean test(Person p) {
		int checkAge = p.getCurrentAge();
		if (this.getEligGender() == p.getGender() && 
				checkAge >= minEligAge &&
				checkAge <= maxEligAge)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Calendar currentDate = Calendar.getInstance();
		System.out.println(currentDate.get(Calendar.YEAR) + ":" + currentDate.get(Calendar.MONTH) + ":" + currentDate.get(Calendar.DAY_OF_MONTH));
	}
}
