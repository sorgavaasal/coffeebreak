package chap.six.simple.pracs;

import java.util.List;

import chap.three.simple.pracs.Node;

public class StackImpl<I> extends StackAdt<I> {

	public StackImpl(Node<I> element) {
		super(element);
	}
	
	public StackImpl() {
		super();
	}
	
	public Node<I>[] toArray() {
		@SuppressWarnings("unchecked")
		Node<I>[] stackArray = new Node[this.getSize()];
		int i = 0;
		Node<I> element = this.getHead();
		stackArray[i] = element;
		while (element.getNext() != null) {
			++i;
			stackArray[i] = element.getNext();
			element = stackArray[i];
		}
		return stackArray;
	}
	
	public void removeAllRecurssive(List<Node<I>> stackList) {
		
		if (this.getSize() > 0) {
			stackList.add(this.pop());
			this.removeAllRecurssive(stackList);
		}
		
		return;
	}

 }
