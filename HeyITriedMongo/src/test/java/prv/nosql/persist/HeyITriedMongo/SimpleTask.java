package prv.nosql.persist.HeyITriedMongo;

public class SimpleTask implements Runnable {

	@Override
	public void run() {
		int i = 16;
		int j = 0;
		try {
			int result = i / j;
			System.out.println(" math calculated " + result);
		} catch (ArithmeticException ae) {
			throw ae;
		}
		
		System.out.println("task completed ");
	}

}
