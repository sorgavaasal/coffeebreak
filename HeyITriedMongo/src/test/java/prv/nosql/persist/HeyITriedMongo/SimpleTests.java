package prv.nosql.persist.HeyITriedMongo;

import java.util.ArrayList;
import java.util.List;

public class SimpleTests {
	
	public static void main(String[] args) {
		List<String> simpleList = new ArrayList<>();
		simpleList.add("A");
		simpleList.add("B");
		simpleList.add("C");
		simpleList.add("D");
		simpleList.add("E");
		simpleList.add("F");
		simpleList.add("G");
		simpleList.add("H");
		simpleList.add("I");
		simpleList.add("I");
		simpleList.add("J");
		simpleList.add("K");
		simpleList.add("L");
		simpleList.add("M");
		simpleList.add("N");
		simpleList.add("O");
		simpleList.add("P");
		
		for (int i = 0; i < simpleList.size(); ++i) {
			String content = simpleList.get(i);
			System.out.println(content);
			
			if (i == simpleList.size()-1) {
				System.out.println("reached the last line");
				System.out.println(content);
			}
		}
		
	}

}
