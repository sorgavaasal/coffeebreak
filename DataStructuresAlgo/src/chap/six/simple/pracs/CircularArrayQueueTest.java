package chap.six.simple.pracs;

/***
 * program to test the 
 * @author srividhya
 *
 */
public class CircularArrayQueueTest {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CircularArrayQueue<String> simpleQueue = new CircularArrayQueue<>(String.class); 
		
		System.out.println(simpleQueue.enqueue("A"));
		System.out.println(simpleQueue.enqueue("B"));
		System.out.println(simpleQueue.enqueue("C"));
		System.out.println(simpleQueue.enqueue("D"));
		System.out.println(simpleQueue.enqueue("E"));
		System.out.println(simpleQueue.enqueue("F"));
		System.out.println(simpleQueue.enqueue("G"));
		System.out.println(simpleQueue.enqueue("H"));
		System.out.println(simpleQueue.isFull());
		System.out.println(simpleQueue.isEmpty());
		System.out.println(simpleQueue.peek());
		System.out.println(simpleQueue.offer("I"));
	}
}
