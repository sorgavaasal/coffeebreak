package chap.five.simple.pracs;

/***
 * simple example for Recursive factorial  
 * @author srividhya
 *
 */
public class FactorialRecu {
	
	private static int generateFactor(int num) {
		
		if  (num == 0) {
			return 1;
		}
		return num * generateFactor(num-1);
	}
	
	public static void main(String[] args) {
		System.out.println(generateFactor(3));
	}

}
