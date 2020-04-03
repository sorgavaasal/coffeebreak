package com.project.euiler;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/***
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * 
 * input file for this problem can be found in largeSum_input
 * @author srividhya
 *
 */

public class LargeSum {
	
	private static void calcLargeSum(String fileLocation) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get(fileLocation))) {
			List<String> flatContent = lines.flatMap(line -> Arrays.stream(line.split("\n"))).collect(toList());
			List<BigInteger> bigIntList = new ArrayList<>();
			BigInteger totalNum = BigInteger.ZERO;
			flatContent.stream().forEach(
					numStr -> 
					{
						System.out.println(numStr);
						bigIntList.add(new BigInteger(numStr));
					});
			
			for (BigInteger num : bigIntList)
				totalNum = totalNum.add(num);
			System.out.println("FinalValue===>" +totalNum);
			System.out.println(flatContent.size());
		}
	}
	
	public static void main(String[] args) throws IOException {
		String fileLocation = "/Users/srividhya/playgrnd/aug232018/coffeebreak/MavenPractiseWorkspace/DataStructuresAlgo/src/com/project/euiler/largeSum_input";
		BigInteger bigInt = new BigInteger("37107287533902102798797998220837590246510135740250");
		System.out.println(bigInt);
		calcLargeSum(fileLocation);
	}

}
