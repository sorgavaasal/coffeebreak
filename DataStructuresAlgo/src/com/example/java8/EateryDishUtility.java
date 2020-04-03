package com.example.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

import com.example.common.classes.Dish;

public class EateryDishUtility {
	
	public static List<Dish> makeMockDishList() {
		
		List<Dish> dishes = Arrays.asList(
				new Dish("Scrambled_eggs", false, 250, Dish.Type.OTHER),
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french_fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("fruit_salad", true, 120, Dish.Type.OTHER),
				new Dish("Pizza", true, 550, Dish.Type.OTHER),
				new Dish("Prawns", false, 300, Dish.Type.FISH),
				new Dish("Salmon", true, 450, Dish.Type.FISH)
				);
		
		return dishes;
	}
	
	public static void main(String[] args) {
		List<Dish> dishList = makeMockDishList();
		List<String> dishNames = dishList.stream().map(Dish::getName).collect(toList());
		System.out.println("list of all the dishes Names===>");
		System.out.println(dishNames);
		
		List<String> otherTypeDishes = dishList.stream()
				.filter((Dish d) -> d.getType() == Dish.Type.OTHER)
				.map(Dish::getName)
				.collect(toList());
		
		System.out.println(" OtherTypeDishes===>");
		otherTypeDishes.forEach(System.out::println);
		
		Predicate<Dish> othrTypeDish = (Dish d) -> d.getType() == Dish.Type.OTHER;
		
		List<String> nonMeatTypeDishes = dishList.stream()
				.filter(othrTypeDish.or((Dish d) -> d.getType() == Dish.Type.FISH)).map(Dish::getName)
				.collect(toList());				
		
		System.out.println("nonMeatTypeDishes===>");
		nonMeatTypeDishes.forEach(System.out::println);
		
		System.out.println(" Meat type of food===>");
		List<String> meatTypeDishes = dishList.stream()
				.filter((Dish d) -> d.getType() == Dish.Type.MEAT).map(Dish::getName)
				.collect(toList());
		meatTypeDishes.forEach(System.out::println);
	}

}
