package com.example.java8;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.stream.Collectors.reducing;

import com.example.common.classes.Dish;
import static com.example.java8.EateryDishUtility.makeMockDishList;

public class ExtendedEateryUtility {
	public static void main(String[] args) {
		List<Dish> menu = makeMockDishList();
		
		
		Optional<Dish> mostCalories = menu.stream()
				.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalories.map(Dish::getCalories));
		System.out.println(mostCalories.map(Dish::getName));
	}
}
