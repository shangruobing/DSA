package Experiment_9;

import java.util.Iterator;

public class LinkedList<T> implements ListADT<T>,Iterable<T> {
	protected int count;
	protected LinearNode<T> head, tail;
	public LinkedList(){
		count = 0;
		head = tail = null;
	}
	public T remove(T targetElement) throws ElementNotFoundException, EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("List");
		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		while(current !=null &&!found)
			if(targetElement.equals(current.getElement()))
				found = true;
			else
			{ previous = current;
				current = current.getNext();
			}
		if(!found)
			throw new ElementNotFoundException("List");
		if(size()==1)
			head=tail=null;
		else if(current.equals(head))
			head=current.getNext();
		else if(current.equals(tail))
		{ tail = previous;
			tail.setNext(null);
		}
		else
			previous.setNext(current.getNext());
		count--;
		return current.getElement();
	}

	public boolean contains(T targetElement) {
		LinearNode<T> current=head;
		while(current !=null)
			if(targetElement.equals(current.getElement()))
				return true;
			else
				current = current.getNext();
		return false;
	}
	public T first() {
	return null;
	}
	public boolean isEmpty() {
		return true;
	}
	public Iterator<T> iterator() {
		return new LinkedIterator<T>(head,count);
	}
	public T last() {
		return null;
	}
	public T removeFirst() throws EmptyCollectionException {
		return null;
	}
	public T removeLast() {
		return null;
	}
	public int size() {
		return 3;
	}

}
