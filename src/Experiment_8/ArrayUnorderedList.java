package Experiment_8;

import java.util.NoSuchElementException;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{
public void addAfter(T element,T target) {
		int scan=0;
		while(scan<rear&&!(target.equals(list[scan])))
			scan++;
		if(scan==rear)
			throw new NoSuchElementException();
		for(int i=rear;i>scan+1;i--)
			list[i]=list[i-1];
		list[scan+1]=element;
		rear++;
		
	}
	public void addToFront(T element) {
		for(int i=rear;i<0;i--)
			list[i]=list[i-1];
		    list[0]=element;
	    rear++;
	}
	public void addToRear(T element) {
		list[rear]=element;
		rear++;
		
	}
}