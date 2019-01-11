package com.example.java7;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LoadPersonList {

	private List<Person> personList = new ArrayList<>();
	private static LoadPersonList loadPersonList;
	

	public List<Person> getPersonList() {
		return personList;
	}
	
	private LoadPersonList() {		
	}
	
	public static LoadPersonList getInstance() {
		if (loadPersonList == null) {
			loadPersonList = new LoadPersonList();
		}
		
		return loadPersonList;
	}
	
	public void loadDummyDateToPersonList() {
		Person personA = new Person();
		personA.setName("Messi Argentina");
		Calendar dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.JANUARY);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1981);
		personA.setBirthday(dobData.getTime());
		personA.setEmailAddress("messi@yahoo.com");
		personA.setGender(Person.Sex.MALE);
		personList.add(personA);
		
		Person personB = new Person();
		personB.setName("Ronaldo Brazil");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.FEBRUARY);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1981);
		personB.setBirthday(dobData.getTime());
		personB.setEmailAddress("Ronaldo@yahoo.com");
		personB.setGender(Person.Sex.MALE);
		personList.add(personB);
		
		Person personC = new Person();
		personC.setName("Ranatunga Srilanka");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.JUNE);
		dobData.set(Calendar.DATE, 10);
		dobData.set(Calendar.YEAR, 1984);
		personC.setBirthday(dobData.getTime());
		personC.setEmailAddress("Ranatunga@yahoo.com");
		personC.setGender(Person.Sex.MALE);
		personList.add(personC);
		
		Person personD = new Person();
		personD.setName("JayaSurya Srilanka");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.MARCH);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1982);
		personD.setBirthday(dobData.getTime());
		personD.setEmailAddress("Jayasurya@yahoo.com");
		personD.setGender(Person.Sex.MALE);
		personList.add(personC);
		
		Person personE = new Person();
		personE.setName("KapilDev India");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.APRIL);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1982);
		personE.setBirthday(dobData.getTime());
		personE.setEmailAddress("Kapil@yahoo.com");
		personE.setGender(Person.Sex.MALE);
		personList.add(personE);
		
		Person personF = new Person();
		personF.setName("Phelphs USA");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.MAY);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1983);
		personF.setBirthday(dobData.getTime());
		personF.setEmailAddress("Phelps@yahoo.com");
		personF.setGender(Person.Sex.MALE);
		personList.add(personF);
		
		
		Person personG = new Person();
		personG.setName("SerenaaWilliams USA");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.MAY);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1984);
		personG.setBirthday(dobData.getTime());
		personG.setEmailAddress("Williams@yahoo.com");
		personG.setGender(Person.Sex.FEMALE);
		personList.add(personG);

		Person personH = new Person();
		personH.setName("Dhoni India");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.JULY);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1981);
		personH.setBirthday(dobData.getTime());
		personH.setEmailAddress("Dhoni@gmail.com");
		personH.setGender(Person.Sex.MALE);
		personList.add(personH);

		Person personI = new Person();
		personI.setName("RobinSingh India");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.DECEMBER);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1983);
		personI.setBirthday(dobData.getTime());
		personI.setEmailAddress("rSingh@gmail.com");
		personI.setGender(Person.Sex.MALE);
		personList.add(personI);

		Person personJ = new Person();
		personJ.setName("DhanrajPillai India");
		dobData = Calendar.getInstance();
		dobData.set(Calendar.MONTH, Calendar.NOVEMBER);
		dobData.set(Calendar.DATE, 1);
		dobData.set(Calendar.YEAR, 1985);
		personJ.setBirthday(dobData.getTime());
		personJ.setEmailAddress("pillai@gmail.com");
		personJ.setGender(Person.Sex.MALE);
		personList.add(personJ);
	}

}
