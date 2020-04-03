package com.example.java8;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class SimpleNumberFilter {
	
	private static List<Integer> mockANumberList(){
		List<Integer> numbList = Arrays.asList(1, 2, 3, 3, 4, 5, 6,7, 8 ,99, 9, 100, 100, 8, 5, 4 );
		List<Integer> uniqueList = numbList.stream().distinct().collect(toList());
		
		return numbList;
	}
	
	public static void main(String[] args) {
		
		List<Integer> uniqueList = (mockANumberList()).stream().distinct().collect(toList());
		System.out.println(uniqueList);
		
		List<Integer> sortedList = (mockANumberList()).stream().sorted().collect(toList());
		System.out.println(sortedList);
		//System.out.println(mockANumberList()).sort(Integer::compareTo));
		
		List<Integer> uniqueSortedList = (mockANumberList()).stream().distinct().sorted().collect(toList());
		System.out.println(uniqueSortedList);
		
	}

}
