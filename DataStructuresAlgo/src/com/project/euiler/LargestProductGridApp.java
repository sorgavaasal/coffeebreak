package com.project.euiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/***
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.

What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?

problem number 11

the grid mentioned in the above question can be found in largestProductGrid_input
 * @author srividhya
 *
 */
public class LargestProductGridApp {

	/**
	 * Parses the input file and builds the matrix in the List<List<String>>
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static List<List<String>> getGridContent(String fileName) throws IOException {

		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			// Reads the file stream from the try and parses the lines based
			// on new line character, which is collected in the lineContent
			// *
			List<String> lineContent = lines.flatMap(line -> Arrays.stream(line.split("\n"))).collect(toList());
			List<List<String>> fileContents = new ArrayList<>();
			lineContent.stream()
					.forEach(inputStr -> fileContents.add(Arrays.stream(inputStr.split(" ")).collect(toList())));

			fileContents.forEach(System.out::println);

			return fileContents;
		}
	}

	/**
	 * finding the largest product in the matrix
	 * 
	 * @param inputMatrix
	 */
	private static void findLargestProduct(List<List<String>> inputMatrix) {

		Integer eastProduct = 0;
		Integer westProduct = 0;
		Integer northProduct = 0;
		Integer southProduct = 0;
		Integer neProduct = 0;
		Integer nwProduct = 0;
		Integer seProduct = 0;
		Integer swProduct = 0;

		Integer product = 0;

		int i = 0;
		int j = 0;

		Integer[][] arrayMatrix = new Integer[20][20];

		// * load the arrayMatrix from arrayList
		for (List<String> line : inputMatrix) {
			for (String inpChar : line) {

				try {
					arrayMatrix[j][i] = Integer.valueOf(inpChar);
				} catch (ArrayIndexOutOfBoundsException ae) {
					ae.printStackTrace();
					System.out.println("i" + i);
					System.out.println("j" + j);
					throw ae;
				}
				++i;
			}
			++j;
			i = 0;
		}

		i = 0;
		j = 0;

		// * find maximum arrayMatrix value
		try {

			for (j = 0; j < 20; ++j) {
				for (i = 0; i < 20; ++i) {
					boolean[] dirMat = getIdxExtrPol(i, j);

					if (dirMat[0]) {
						product = arrayMatrix[j][i] * arrayMatrix[j][i + 1] * arrayMatrix[j][i + 2]
								* arrayMatrix[j][i + 3];
						if (product > eastProduct)
							eastProduct = product;

					}

					if (dirMat[1]) {
						product = arrayMatrix[j][i] * arrayMatrix[j][i - 1] * arrayMatrix[j][i - 2]
								* arrayMatrix[j][i - 2];
						if (product > westProduct)
							westProduct = product;
					}

					if (dirMat[2]) {
						product = arrayMatrix[j][i] * arrayMatrix[j - 1][i] * arrayMatrix[j - 2][i]
								* arrayMatrix[j - 3][i];
						if (product > northProduct)
							northProduct = product;
					}

					if (dirMat[3]) {
						product = arrayMatrix[j][i] * arrayMatrix[j + 1][i] * arrayMatrix[j + 2][i]
								* arrayMatrix[j + 3][i];
						if (product > eastProduct)
							southProduct = product;
					}

					// *north east product calculation
					if (dirMat[4]) {
						product = arrayMatrix[j][i] * arrayMatrix[j - 1][i + 1] * arrayMatrix[j - 2][i + 2]
								* arrayMatrix[j - 3][i + 3];
						if (product > neProduct)
							neProduct = product;
					}

					// *north west product calculation
					if (dirMat[5]) {
						product = arrayMatrix[j][i] * arrayMatrix[j - 1][i - 1] * arrayMatrix[j - 2][i - 2]
								* arrayMatrix[j - 3][i - 3];
						if (product > nwProduct)
							nwProduct = product;
					}

					// *south east product calculation
					if (dirMat[6]) {
						product = arrayMatrix[j][i] * arrayMatrix[j + 1][i + 1] * arrayMatrix[j + 2][i + 2]
								* arrayMatrix[j + 3][i + 3];
						if (product > seProduct)
							seProduct = product;
					}

					// *south west product calculation
					if (dirMat[7]) {
						product = arrayMatrix[j][i] * arrayMatrix[j + 1][i - 1] * arrayMatrix[j + 2][i - 2]
								* arrayMatrix[j + 3][i - 3];
						if (product > swProduct)
							swProduct = product;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
			System.out.println("i===>" + i);
			System.out.println("j===>" + j);
			System.out.println("arrayValue===>" + arrayMatrix[j][i]);
			throw ae;
		}

		System.out.println("eastProduct===>" + eastProduct);
		System.out.println("westProduct===>" + westProduct);
		System.out.println("northProduct===>" + northProduct);
		System.out.println("southProduct===>" + southProduct);
		System.out.println("northEastProduct===>" + neProduct);
		System.out.println("northwesProduct===>" + nwProduct);
		System.out.println("southEastProduct===>" + seProduct);
		System.out.println("southWestProduct===>" + swProduct);

		Integer[] output = { eastProduct, westProduct, northProduct, southProduct, neProduct, nwProduct, seProduct,
				swProduct };

		(Arrays.stream(output).collect(toList())).sort((Integer i1, Integer i2) -> (i1.compareTo(i2)));
		List<Integer> outputList = Arrays.stream(output).collect(toList());
		System.out.println("outputList===Before===Sorting" + outputList);
		outputList.sort((Integer i1, Integer i2) -> i1.compareTo(i2));
		System.out.println("outputList===After===Sorting" + outputList);
	}

	/**
	 * finds if the array index position has values in the 8 directions of 
	 * the index position, if it has the boolean for the direction will be true 
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean[] getIdxExtrPol(int i, int j) {
		boolean[] matrixDir = new boolean[8];

		// East direction calculation for each line
		if (i > 0 && i < 17)
			matrixDir[0] = true;

		// South Direction calculation for each line
		if (j > 0 && j < 17)
			matrixDir[3] = true;

		// north direction calculation for each line
		if (j > 2 && j <= 20)
			matrixDir[2] = true;

		// west direction calculation for each line
		if (i > 2 && i <= 20)
			matrixDir[1] = true;

		// south east direction calculation for each line
		if (i > 0 && i < 17 && j < 17)
			matrixDir[6] = true;

		// south west direction calculation for each line
		if (i > 2 && i <= 20 && j < 17)
			matrixDir[7] = true;

		// north east direction calculation for each line
		if (j > 2 && j <= 20 && i > 0 && i < 17)
			matrixDir[4] = true;

		// northwest direction calculation for each line
		if (j > 2 && j <= 20 && i > 2 && i <= 20)
			matrixDir[5] = true;

		return matrixDir;
	}

	public static void main(String[] args) {
		try {
			String file_location = "/Users/srividhya/playgrnd/aug232018/coffeebreak/MavenPractiseWorkspace/DataStructuresAlgo/src/com/project/euiler/largestProductGrid_input";
			findLargestProduct(getGridContent(file_location));
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

}
