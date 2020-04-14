package chap.six.simple.pracs;

public interface Queue<T> {
	
	public boolean enqueue(T element);
	
	public T dequeue();
	
	public T peek();
	
	public boolean offer(T element);
	
	public boolean isEmpty();
	
	public boolean isFull();

}
