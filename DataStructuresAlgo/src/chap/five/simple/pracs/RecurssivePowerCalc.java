package chap.five.simple.pracs;

public class RecurssivePowerCalc {
	
	private static int calcPower(int num, int degree) {
		
		if (degree == 0) {
			return 1;
		} else {
			if (degree%2 == 0) {
				System.out.println("inside even calc");
				int result = calcPower(num, degree / 2);
				return result * result;
			} else {
				System.out.println("inside odd calc");
				int result = calcPower(num, degree / 2);
				return result * result * num;
			}
			//return num * calcPower(num, degree-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(calcPower(2, 5));
	}

}
