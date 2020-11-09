package Experiment_8;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {
	public T removeFirst() throws EmptyCollectionException;
	public T removeLast()throws EmptyCollectionException;
	public T remove(T element) throws ElementNotFoundException, EmptyCollectionException;
	public T first();
	public T last();
	public boolean contains(T target);
	public boolean isEmpty();
	public int size();
	public Iterator<T> iterator();
	public String toString();

}
