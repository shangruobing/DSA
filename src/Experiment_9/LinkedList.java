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

	public T first(){
		return head.getElement();
	}

	public boolean isEmpty() {
		return count==0;
	}

	public Iterator<T> iterator() {
		return new LinkedIterator<T>(head,count);
	}

	public T last() {
		return tail.getElement();
	}

	public T removeFirst() throws EmptyCollectionException {
		T result;
		if (isEmpty())
			throw new EmptyCollectionException("List");
		else
			result=head.getElement();
			head.setElement(null);
			head=head.getNext();
			count--;
			return result;
	}
	public T removeLast() {
		T result;
		result=tail.getElement();
		tail.setElement(null);
		count--;
		return result;

	}
	public int size() {
		return count;
	}

	public String toString(){
		LinearNode<T> store; //用于储存head的初始值
		String result;
		result="";
		store=head;
		for (int i=0;i<count;i++){
			result+=head.getElement().toString()+"->";

			if (head.getNext()!=null)
				head = head.getNext();
			System.out.println(head);
		}
		head=store;
		result+="null}";
		return result;
	}
}
