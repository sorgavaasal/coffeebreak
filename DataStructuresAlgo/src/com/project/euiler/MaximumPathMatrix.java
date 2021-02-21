package com.project.euiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This code is to solve the maximum path sum problem in
 * Project Euler 18.
 * @author srividhya
 *
 */
public class MaximumPathMatrix {

	/**
	 * @throws IOException 
	 * 
	 */
	private static List<String> readInputFile(String filePath, String fileName) throws IOException {
		return Files.readAllLines(Paths.get(filePath, fileName));
	}
	
	private static Integer [][] convertLinePathsToMatrix(List<String> inputLines) {
		int rowSize = inputLines.size();
		int colSize = inputLines.get(rowSize - 1).split(" ").length;
		
		Integer [][] runnerMatrix = new Integer[rowSize][colSize];
		
		int i = 0;
		int j = 0;

		for (String line : inputLines) {
			String[] lineSplit = line.trim().split(" ");
			
			for (String lineSplitNum : lineSplit) {
				runnerMatrix [i] [j] = Integer.valueOf(lineSplitNum);
				++j;
			}
			
			while (j < colSize) {
				runnerMatrix[i] [j] = 0;
				++j;
			}
			
			++i;			
			j = 0;
		}
		
		return runnerMatrix;
	}
	
	@SuppressWarnings("unused")
	private static void printRunnerMatrix(Integer[] [] runnerMatrix) {
		for (Integer[] matrixLine : runnerMatrix) {
			for (Integer number : matrixLine) {
				
				System.out.print(prefixZero(number));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static String prefixZero(int number) {
		if (String.valueOf(number).length() == 1) {
			return "000" + String.valueOf(number);
		} else if (String.valueOf(number).length() == 2) {
			return "00" + String.valueOf(number);
		} else if (String.valueOf(number).length() == 3 ) {
			return "0" + String.valueOf(number);
		} else {
			return String.valueOf(number);
		}
	}
	
	/**
	 *	Main logic for calculating the maximum path 
	 * @param runnerMatrix
	 */
	private static void calculateMaxPath(Integer[] [] runnerMatrix) {
		int i = runnerMatrix.length-1;
		
		while (i > 0) {
			
			int startIndex = 0;

			if (i > 0) {
				startIndex = i-1;
			} else {
				startIndex = 0;
			}
				
			for (int j = 0; j < runnerMatrix[startIndex].length-1; ++j) {
				int num1 = runnerMatrix[startIndex][j];
				int num2 = runnerMatrix[startIndex+1][j];
				int num3 = runnerMatrix[startIndex+1][j+1];
				int result1 = Math.max(num1 + num2, num1 + num3);
				runnerMatrix[startIndex][j] = result1;
			}
			--i;
			System.out.println(" Current iteration to be evaluated ===> " +i);
			printRunnerMatrix(runnerMatrix);
		}
		
		System.out.println("sum of maximum Path ===> " +runnerMatrix[0][0]);
	}
	
	public static void main(String[] args) throws IOException {
		List<String> fileLines = readInputFile("/Users/srividhya/Downloads/eulerProblemDocuments/",
		//		"MaximumPathSumInputTriangle_simple");
		//		"MaximumPathSumInputTriangle");
				"MaximumPathSumInputTriangle_diff");
		Integer[] [] runnerMatrix = convertLinePathsToMatrix(fileLines);
		printRunnerMatrix(runnerMatrix);
		calculateMaxPath(runnerMatrix);
	}

}
