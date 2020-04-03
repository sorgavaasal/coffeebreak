package chap.three.simple.pracs;

public class ArrayUtility {

	/**
	 * creates a random number and loads the array and
	 * sends it back 
	 * @param arraySize
	 * @return
	 */
	public Integer[] loadArray(int arraySize) {
		Integer[] myIntArray = new Integer[arraySize];
		
		for (int i=0; i < arraySize; ++i) {
			int randNum = (int) ((Math.random() * 100)/10);
			myIntArray[i] = randNum;
		}
		return myIntArray;
	}
	
	private void printTheArray(Integer[] intArray) {
		for (int i=0; i < intArray.length; ++i) {
			System.out.println(intArray[i]);
		}
	}
	
	public int removeAndGiveRandomItem(Integer[] inputArray) {
		System.err.println("Length of the array before the iteration" +inputArray.length);
		int randNum = (int) ((Math.random() * inputArray.length + 1) / 10);
		System.err.println(" random number generated " +randNum);
		int removeNum = inputArray[randNum]; 
		for (int i=randNum; i < inputArray.length-1; ++i) {
			inputArray[i] = inputArray[i+1];
 		} 
		
		inputArray[inputArray.length-1] = 0;
		System.err.println("length of the array after the iteration " +inputArray.length);
		return removeNum;
	}
 	
	public static void main(String[] args) {
		ArrayUtility arrayGen = new ArrayUtility();
		arrayGen.printTheArray(arrayGen.loadArray(50));
	}
	
}
