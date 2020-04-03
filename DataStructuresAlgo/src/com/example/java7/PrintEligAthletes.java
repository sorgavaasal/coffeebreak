package com.example.java7;

import java.util.List;

import com.example.java7.Person.Sex;

public class PrintEligAthletes {
	
	public static List<Person> runStaticPersonLoad() {
		LoadPersonList loadPersonList = LoadPersonList.getInstance();
		loadPersonList.loadDummyDateToPersonList();
		return loadPersonList.getPersonList();
	}
	
	/**
	 *  report runner interface implementation  
	 */
	public static void reportRunnerInterfaceImpl(List<Person> personList, CheckPerson tester) {
/*		for (Person individual : personList) {
			if (tester.test(individual)) {
				individual.printPerson();
			}
		}
*/	
		//* changed the enhanced for loop lambda for each 
		personList.forEach((individual) -> {
			if (tester.test(individual)  ) {
				individual.printPerson();
			}
		});
	}
	
	/**
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIndvEligForSelectSvc tester = new CheckIndvEligForSelectSvc();
		tester.setEligGender(Person.Sex.MALE);
		tester.setMinEligAge(20);
		tester.setMaxEligAge(32);
		List<Person> personList = runStaticPersonLoad();
		//reportRunnerInterfaceImpl(personList, tester);
		
		reportRunnerInterfaceImpl(personList, new CheckPerson() {
			int minAge = 30;
			int maxAge = 37;
			Person.Sex eligGender = Sex.MALE;

			@Override
			public boolean test(Person individual) {
				int checkAge = individual.getCurrentAge();
				if (individual.getGender().equals(this.eligGender) && checkAge >= minAge && checkAge <= maxAge)
					return true;
				return false;
			}
			
		});
		System.err.println("Lamda Expression Implementation");
		int minAge = 35; int maxAge = 37;
		reportRunnerInterfaceImpl(personList,
				(Person person) -> person.getGender() == Person.Sex.MALE &&
				person.getCurrentAge() >= minAge && person.getCurrentAge() <= maxAge);
			
		
	}
	
}

