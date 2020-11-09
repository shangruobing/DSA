package Experiment_8;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T>,Iterable<T>{
	protected final int DEFAULT_CAPACITY=100;
	private final int NOT_FOUND = -1;
	protected int rear;
	protected T[] list;
	public ArrayList(){
		rear = 0;
		list = (T[])(new Object[DEFAULT_CAPACITY]);
	}
	public ArrayList(int initialCapacity){
		rear = 0;
		list = (T[])(new Object[initialCapacity]);		
	}
	public T remove(T element) throws ElementNotFoundException{
		T result;
		int index = find(element);
		if(index == NOT_FOUND)
			throw new ElementNotFoundException("list");

		result = list[index];
		rear--;
		for(int scan=index;scan<rear; scan++)
			list[scan]=list[scan+1];
		list[rear]=null;
		return result;
	}
	private int find(T target){
		int scan = 0, result = NOT_FOUND;	
		boolean found = false;
		if(!isEmpty())
			while(!found && scan<rear)
				if(target.equals(list[scan]))
					found=true;
				else scan++;
		if(found)
			result=scan;
		return result;
	}
    public void expandCapacity()
    {
    	T[] larger = (T[])(new Object[list.length*2]);
    	for (int scan=0;scan<rear; scan++)
    	  larger[scan] =list[scan];
    	list = larger;
    }
	public boolean contains(T target){
		return (find(target)!=NOT_FOUND);
	}

	public Iterator<T> iterator(){
		return new ArrayIterator<T>(list,rear);
	}
	public T first() {
		return list[0];
	}
	public boolean isEmpty() {
		return list[0] == null;
	}
	public T last() {
		return list[rear];
	}
	public T removeFirst() throws EmptyCollectionException {
		T result;
		int index = find(first());
		if(index == NOT_FOUND)
			throw new EmptyCollectionException("list");

		result = list[0];
		for(int scan=index;scan<rear; scan++)
			list[scan]=list[scan+1];
		list[0]=null;
		return result;
	}
	public T removeLast() throws EmptyCollectionException {
		T result;
		int index = find(first());
		if(index == NOT_FOUND)
			throw new EmptyCollectionException("list");

		result = list[rear];
		rear--;
		for(int scan=index;scan<rear; scan++)
			list[scan]=list[scan+1];
		list[rear]=null;
		return result;
	}
	public int size() {
		return rear+1;
	}
    public String toString(){
    	String result="线性表{";
    	for (int scan=0;scan<rear;scan++)
    		result+=list[scan].toString()+"->";
    	result+="null}";
    	return result;
    }
}
