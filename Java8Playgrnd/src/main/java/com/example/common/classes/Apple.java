package com.example.common.classes;

public class Apple {
	
	public Apple(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}
	
	public Apple() {
		
	}
	
	private String color;
	private double weight;

	public enum appleColor {
		green ("green"), 
		red ("red"), 
		yellow ("yellow");
		
		private String enumColor; 
		
		private appleColor(String color) {
			this.enumColor = color;
		}
		public String getValue() {
			return enumColor; 
		}
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
