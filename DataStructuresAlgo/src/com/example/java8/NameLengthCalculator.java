package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NameLengthCalculator {
	
	public static <T> List<T> filter(List<T> inputList, Predicate<T> p) {
		
		List<T> returnList = new ArrayList<>();
		for (T element : inputList) {
			if (p.test(element)) {
				returnList.add(element);
			}
		}
		return returnList;
	}

	public static void main(String[] args) {
		List<String> inputList = new ArrayList<>();
		inputList.add("Govind Raj");
		inputList.add("ShankarNarayanan");
		inputList.add("Ramanathan");
		inputList.add("Sridhar");
		inputList.add("Muruganandam");
		inputList.add("GaneshRam");
		inputList.add("Raghavendran");
		//* predicate used instead of executing and inner class
		Predicate<String> predicate = (String s) -> s.length() > 7;
		List<String> resultList = filter(inputList, predicate);
		
		List<String> newResultList = filter(inputList, (String s) -> s.length() > 10);
		System.out.println("greater than 10 list");
		newResultList.forEach(System.out::println);
		System.out.println("greater Than 7 list");
		resultList.forEach(System.out::println);
		//*Example of predicate used to check if an List is empty or not 
		Predicate<List<String>> press = (List<String> resultLists) -> resultLists.isEmpty();
		
		System.out.println(press.test(resultList));
		
	}
}
