package com.example.java8;

public class AllStringOperation {
	
	public static void main(String[] args) {
		
		// 
		AllStringOperation operation = new AllStringOperation();
		
		Manipulator manipulator = (CharSequence a, CharSequence b) -> 
					{   String xx = (String) a;
						String xy = (String) b;
						return xy.length() + xx.length(); 
					};

		System.out.println("lenght of the String ====> " + operation.getCumulativeLength("Sridhar Raman", 
				"Srividhya Ravichandran", manipulator));
	}
	
	/**
	 * 
	 * @param stra
	 * @param strb
	 * @param manipulator
	 * @return
	 */
	public int getCumulativeLength(String stra, String strb, Manipulator manipulator) {
		return manipulator.getCumulativeLength(stra, strb);
	}
	
	interface Manipulator {
		int getCumulativeLength(CharSequence a, CharSequence b);
	}

}
