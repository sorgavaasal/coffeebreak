package chap.six.simple.pracs;

import chap.three.simple.pracs.DoubleEndedQueue;

public class QueueUnitTesting {

	public static LinkedListQueue<String> getStaticTestQueue() {
		LinkedListQueue<String> input = new LinkedListQueue<>();
		
		input.enqueue("A");
		input.enqueue("B");
		input.enqueue("C");
		input.enqueue("D");
		input.enqueue("E");
		input.enqueue("F");
		input.enqueue("G");
		input.enqueue("H");
		input.enqueue("I");
		input.enqueue("J");
		input.enqueue("K");
		input.enqueue("L");
		input.enqueue("M");
		input.enqueue("N");
		input.enqueue("O");
		
		return input;
	}
	
	public static void main(String[] args) {
		LinkedListQueue<String> input = getStaticTestQueue();
		System.out.println(input.getSize());
		System.out.println(input.dequeue());
		System.out.println(input.dequeue());
		System.out.println(input.dequeue());
		System.out.println(input.dequeue());
		System.out.println(input.dequeue());
		System.out.println(input.dequeue());
		System.out.println(input.getSize());
		
		DoubleEndedQueue<Integer> intQueue = new DoubleEndedQueue();
		intQueue.addFirst(1);
		intQueue.addLast(2);
		intQueue.addLast(3);
		intQueue.addLast(4);
		intQueue.addLast(5);
		intQueue.addLast(6);
		intQueue.addLast(7);
		intQueue.addLast(8);
		intQueue.addLast(9);
		intQueue.addLast(10);
		DoubleEndedQueue<Integer> ultaQueue = new DoubleEndedQueue<>();
		changeQueueOrder(intQueue, ultaQueue);
		System.out.println(intQueue.getFirst());
		System.out.println(intQueue.getLast());
		System.out.println(intQueue.getSize());
		System.out.println("=======================");
		System.out.println("size of the output queue" +ultaQueue.getSize());
		while (!ultaQueue.isEmpty())
			System.out.print(ultaQueue.removeFirst() + " ");
		System.out.println();
		System.out.println("=======================");
	}
	
	public static void changeQueueOrder(DoubleEndedQueue<Integer> input, DoubleEndedQueue<Integer> output) {
		output.addFirst(input.removeFirst()); //1
		output.addLast(input.removeFirst());  //{1,2}
		output.addLast(input.removeFirst());  //{1,2,3}
		output.addFirst(input.removeFirst()); //{4,1,2,3}
		output.addLast(input.removeFirst());  //{4,1,2,3,5}
		input.addFirst(output.removeFirst()); //{1,2,3,5}  => 4 out to input again to the First of input
		output.addLast(input.removeFirst());  //{1,2,3,5,4} <= move 4 back from input to output to Last
		output.addLast(input.removeFirst()); //{1,2,3,5,4,6}
		output.addLast(input.removeFirst());  //{1,2,3,5,4,6,7}  
		output.addLast(input.removeFirst()); // {1,2,3,5,4,6,7,8}
		output.addLast(input.removeFirst()); // {1,2,3,5,4,6,7,8,9}
		output.addLast(input.removeFirst()); //  {1,2,3,5,4,6,7,8,9,10}
		//output.addLas
		//output.addFirst(input.g)
		//output.addFirst(input.getFirst());
		
	}
	
}
