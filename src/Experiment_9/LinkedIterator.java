package Experiment_9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
	private int count;
	private LinearNode<T> current;
	public LinkedIterator (LinearNode<T> collection, int size){
		current= collection;
		count = size;
	}
	public boolean hasNext(){
		return (current!=null);
	}
	public T next(){
		if(!hasNext())
			throw new NoSuchElementException();
		T result = current.getElement();
		current=current.getNext();
		return result;
	}
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
