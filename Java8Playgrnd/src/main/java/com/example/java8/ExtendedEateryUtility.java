package com.example.java8;

import static com.example.java8.EateryDishUtility.makeMockDishList;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.common.classes.Dish;

public class ExtendedEateryUtility {
	public static void main(String[] args) {

		List<Dish> menu = makeMockDishList();
		
		Optional<Dish> mostCalories = menu.stream()
				.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.print(mostCalories.map(Dish::getCalories).get() + " ");
		System.out.println(mostCalories.map(Dish::getName).get());
		
		int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i+j ));
		System.out.println("total calories of all the dishes " +totalCalories);
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType)); 		
		dishesByType.keySet().stream().collect(toList()).forEach(System.out::println);
	}
}