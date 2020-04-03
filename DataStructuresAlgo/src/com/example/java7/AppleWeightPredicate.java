package com.example.java7;

import com.example.common.classes.Apple;
import com.example.common.classes.ApplePredicate;

public class AppleWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150; 
	}
}
