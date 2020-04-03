package chap.three.simple.pracs;

public class INode<E> {
	
	private INode<E> next = null;
	private INode<E> prev = null;
	private E element;
	
	public INode(E element, INode<E> next, INode<E> prev) {
		this.next = next;
		this.prev = prev;
		this.element = element;
	}					
	
	public void setNext(INode<E> next) {
		this.next = next;
	}
	
	public INode<E> getNext() {
		return this.next;
	}
	
	public void setPrev(INode<E> prev) {
		this.prev = prev;
	}
	
    public INode<E> getPrev() {
    	 return this.prev;
    }
    
    public E getElement() {
    	return this.element;
    }
 
}
