package chap.three.simple.pracs;

public class TestProgramAchiever {
	
	public static void main(String[] args) {
		//*instantiate the test class and execute the method you want to
		Integer[] inputArray = {9, 8, 7 ,6 ,5, 4, 3, 2, 1, 0, 10, 11 ,12 ,13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println("Length of the array" +inputArray.length);
		System.out.println("content of the array");
		for (int i: inputArray) {
			System.out.print(" " + i + " ");
		}
		System.out.println(" ======================= ");
		ArrayUtility arrayUtility = new ArrayUtility();
		int numRemoved = arrayUtility.removeAndGiveRandomItem(inputArray);
		System.err.println(" ======================= after utility execution ================== ");
		System.err.println("Length of the array" +inputArray.length);
		System.out.println("content of the array ");
		for (int i: inputArray) {
			System.out.print(" " + i + " ");
		}
		System.out.println(" number removed from the array" + numRemoved);

	}

}
