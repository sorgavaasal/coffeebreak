package com.project.euiler;

/**
 * Converts a number from number to String 
 * @author srividhya
 *
 */
public class DollarAmtTransalator {

	public static String amountTranslator (int amount ) {
		if (amount > 999) {
			//give back Exception illegal amount exception 
		}
		
		StringBuilder stringValue = new StringBuilder();
		
		//If amount is greater than 100 
		if (amount >= 100) {
			// Divide amount by 100 
			int inHundreds = amount / 100;
			if (inHundreds > 0) {
				stringValue.append(getNumberInString(inHundreds));
				stringValue.append("Hundred ");
			} 
			
			amount = Integer.valueOf((String.valueOf(amount)).substring(1));
			if (amount > 0) {
				stringValue.append("and ");
			}
		}
		
		if (amount > 0) {
			
			int inTence = amount / 10;
		
			if (inTence > 1 && inTence <= 9) {
				stringValue.append(getTenceDigStr(inTence));
				if (String.valueOf(amount).length() > 1) {
					int unitDigit = Integer.valueOf(String.valueOf(amount).substring(1));
					stringValue.append(getNumberInString(unitDigit));
				}
			} else if (String.valueOf(amount).length() > 1 && inTence == 1) {
				stringValue.append(getLessThanTwntsNum(amount));
			} else if (String.valueOf(amount).length() > 1 && inTence == 0) {
				stringValue.append("Ten ");
			} else if (String.valueOf(amount).length() == 1 && amount > 0 ) {
				stringValue.append(getNumberInString(amount));
			}
		}
		
		//stringValue.append("Dollars ");
	
		return stringValue.toString();
	}
	
	private static String getNumberInString(int number) {
		
		String numStr = " ";
		switch (number) {
		case 1:
			numStr = "One ";
			break;
		case 2:
			numStr = "Two ";
			break;
		case 3:
			numStr = "Three ";
			break;
		case 4:
			numStr = "Four ";
			break;
		case 5:
			numStr = "Five ";
			break;
		case 6:
			numStr = "Six ";
			break;
		case 7:
			numStr = "Seven ";
			break;
		case 8:
			numStr = "Eight ";
			break;
		case 9:
			numStr = "Nine ";
			break;
		}
		
		return numStr;
	}
	
	private static String getTenceDigStr (int number) {
		String tenceDigStr = " ";
		
		switch (number) {
		case 2:
			tenceDigStr = "Twenty ";
			break;
		case 3:
			tenceDigStr = "Thirty ";
			break;
		case 4:
			tenceDigStr = "Forty ";
			break;
		case 5:
			tenceDigStr = "Fifty ";
			break;
		case 6:
			tenceDigStr = "Sixty ";
			break;
		case 7:
			tenceDigStr = "Seventy ";
			break;
		case 8:
			tenceDigStr = "Eighty ";
			break;
		case 9:
			tenceDigStr = "Ninety ";
			break;
		}
		
		return tenceDigStr;
	}
	
	private static String getLessThanTwntsNum(int number) {
		
		String lessThanTwen  = " ";
		switch (number) {
		case 10:
			lessThanTwen= "Ten ";
			break;
		case 11:
			lessThanTwen = "Eleven ";
			break;
		case 12:
			lessThanTwen = "Twelve ";
			break;
		case 13:
			lessThanTwen = "Thirteen ";
			break;
		case 14:
			lessThanTwen = "Fourteen ";
			break;
		case 15:
			lessThanTwen = "Fifteen ";
			break;
		case 16:
			lessThanTwen = "Sixteen ";
			break;
		case 17:
			lessThanTwen = "Seventeen ";
			break;
		case 18:
			lessThanTwen = "Eighteen ";
			break;
		case 19:
			lessThanTwen = "Nineteen ";
			break;
		}
		
		return lessThanTwen;
	}
	
	private static int splitAndFindLength(String numberString) {
		
		int stringLength = 0;
		if (numberString.contains(" ")) {
			String[] numberArray = numberString.split(" ");
			for (String numStr : numberArray) {
				stringLength = stringLength + numStr.trim().length();
			}
		} else {
			stringLength = numberString.length();
		}
			
		return stringLength;
	}
 	
	public static void main(String[] args) {
		
		String stringValue = new String();
		int stringLength = 0;
		for (int i = 1; i <= 999; ++i) {
			stringValue = amountTranslator(i);
			stringLength = stringLength + splitAndFindLength(stringValue);
		}
		
		stringLength = stringLength + splitAndFindLength("One Thousand");
		
		System.out.println("length of String " + stringLength);
	}
}
