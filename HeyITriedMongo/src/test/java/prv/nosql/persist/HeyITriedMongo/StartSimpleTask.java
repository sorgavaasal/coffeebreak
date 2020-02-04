package prv.nosql.persist.HeyITriedMongo;

public class StartSimpleTask {
	
	public static void main(String[] args) {
		Thread myThread = new Thread(new SimpleTask());
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable ex) {
				System.out.println(" UnCaught Exception " +ex);
				ex.printStackTrace();
			}
		};
		myThread.setUncaughtExceptionHandler(handler);
		myThread.start();
	}

}
