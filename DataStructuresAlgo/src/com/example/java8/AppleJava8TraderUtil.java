package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.example.common.classes.Apple;
import com.example.common.classes.ApplePredicate;

public class AppleJava8TraderUtil {
	
	/**
	 * The below method is the utility method used 
	 * to make mock input values for the Apple trader utility 
	 * @return
	 */
	private List<Apple> makeMockAppleInput() {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.red.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.yellow.getValue(), 160));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 140));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 150));
		inventory.add(new Apple(Apple.appleColor.red.getValue(), 148));
		inventory.add(new Apple(Apple.appleColor.green.getValue(), 152));
		return inventory;
	}

	/***
	 * takes an inventory list and a predicate 
	 * to list out only yellow Apples 
	 * @param inventory
	 * @param predicate
	 */
	private void getYellowApples(List<Apple> inventory, ApplePredicate predicate) {
		
		//java7 foreach loop
	/*	for (Apple a : inventory) {
			if (predicate.test(a)) {
				System.out.println(a.getColor() + "===" +a.getWeight());
			}
		}
*/		
		//java8 foreach loop 
		inventory.forEach((a)->{
			if (predicate.test(a)) {
				System.out.println(a.getColor() + "===" +a.getWeight());
				System.out.println("super foreach");
			}
		});
	}
	
	private void getRedAndMediumWeightApple(List<Apple> inventory, 
			ApplePredicate redPredicate, 
			ApplePredicate weightPredicate) {
		
		inventory.forEach((apple)-> {
			if (redPredicate.test(apple) && weightPredicate.test(apple)) {
				System.out.println(apple.getColor() + "===" +apple.getWeight());
			}
		});
		
	}
	
	public static void main(String[] args) {
		Supplier<AppleJava8TraderUtil> supplier = AppleJava8TraderUtil::new;
		AppleJava8TraderUtil trader = supplier.get();
		// ApplePredicate predicate = (Apple a) ->
		// a.getColor().equals(Apple.appleColor.yellow.getValue());
		// trader.getYellowApples(trader.makeMockAppleInput(), predicate);
		trader.getYellowApples(trader.makeMockAppleInput(),
				(Apple a) -> Apple.appleColor.yellow.getValue().equals(a.getColor()));

		trader.getRedAndMediumWeightApple(trader.makeMockAppleInput(),
				(Apple redColor) -> Apple.appleColor.red.getValue().equals(redColor.getColor()),
				(Apple weightCond) -> weightCond.getWeight() > 150);
	}

}
