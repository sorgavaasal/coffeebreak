package com.example.java7;

import com.example.common.classes.Apple;
import com.example.common.classes.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return Apple.appleColor.green.getValue().equals(apple.getColor());
	}

}
