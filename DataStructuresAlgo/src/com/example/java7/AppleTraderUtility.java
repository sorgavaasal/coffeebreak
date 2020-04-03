package com.example.java7;

import java.util.ArrayList;
import java.util.List;

import com.example.common.classes.Apple;
import com.example.common.classes.ApplePredicate;

public class AppleTraderUtility {
	
	/**
	 * using the predicate built with the ApplePredicate interface
	 * @param inventory
	 * @return
	 */
	public List<Apple> getGreenHighWeightApp(List<Apple> inventory) {
		
		List<Apple> returnInventory = new ArrayList<>();
		for (Apple apple : inventory) {
			boolean colorCond = new AppleGreenColorPredicate().test(apple);
			boolean weightCond = new AppleWeightPredicate().test(apple);
			if (colorCond && weightCond) {
				returnInventory.add(apple);
			}
		}
		return returnInventory;
	}
	
	/**
	 * predicate coded with java 7  
	 * @param args
	 */
	public List<Apple> getRedMediumWeightApp(List<Apple> inventory) {
		List<Apple> returnInventory = new ArrayList<>();
		
		ApplePredicate appleRedColorPredicate = new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return Apple.appleColor.red.getValue().equals(apple.getColor());
			}
		};
		
		ApplePredicate appleWeightPredicate = new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getWeight() > 145;
			}
		};
		
		for (Apple apple : inventory) {
			if (appleRedColorPredicate.test(apple) && appleWeightPredicate.test(apple)) {
				returnInventory.add(apple);
			}
		}

		return returnInventory;
	}
	
	public static void main(String[] args) {
		AppleTraderUtility traderUtility = new AppleTraderUtility();
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.red.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.yellow.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 140));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 150));
		inventory.add(new Apple(Apple.appleColor.red.getValue(), 148));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 152));
		List<Apple> returnList = traderUtility.getGreenHighWeightApp(inventory);
		
		for (Apple returnApple : returnList) {
			System.out.println(returnApple.getColor() + " <===> " +returnApple.getWeight());
		}
		
		List<Apple> returnMediumWeight = traderUtility.getRedMediumWeightApp(inventory);
		
		for (Apple returnApple : returnMediumWeight) {
			System.out.println(returnApple.getColor() + " <===> " + returnApple.getWeight());
		}
	}

}
