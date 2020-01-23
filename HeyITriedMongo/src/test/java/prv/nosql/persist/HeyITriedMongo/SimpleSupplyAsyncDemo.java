package prv.nosql.persist.HeyITriedMongo;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SimpleSupplyAsyncDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		simpleTasks(16, 2);
		simpleTasks(2, 0);
	}
	
	private static void simpleTasks(int i, int j) throws InterruptedException, ExecutionException {
		System.out.println (i + "===" + j);
		
			CompletableFuture<Integer> completetableFuture = CompletableFuture.supplyAsync(() -> {
				try {
				return i / j;
				} catch (Exception ex) {
				  System.out.println(ex.getMessage());	
				  System.out.println("inside the try-catch-clause");
				  throw new CompletionException(ex);
				}

			}).exceptionally(exception -> {
				System.out.println(exception.getMessage());
				System.out.println("inside the Exceptionally Clause ");
				throw new CompletionException(" your input number is divided by zero", exception);
				//return 2000;
			}).orTimeout(10000, TimeUnit.SECONDS).thenApply(result -> {
				result = result + 2;
				System.out.println("value of result " + result);
				return result;
			});

			Thread.sleep(10000);
			System.out.println("thread has woken up");
			
			try {
				completetableFuture.get();
			} catch (Exception e) {
				if (e instanceof ExecutionException) {
					ExecutionException ce = (ExecutionException) e;
					System.out.println(ce.getCause());
					System.out.println("here-we-go-print-stack-trace");
					ce.printStackTrace();
					System.out.println("end of stack trace");
				}

			}
			
			if (completetableFuture.isCompletedExceptionally()) {
				System.out.println ("YAY We can handler exception");
				System.out.println(completetableFuture.isDone());
			} else {
				System.out.println(completetableFuture.get());
			}
			System.out.println(completetableFuture.isCompletedExceptionally());

		// });
		
	}

}
