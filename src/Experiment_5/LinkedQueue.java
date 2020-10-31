package Experiment_5;

public class LinkedQueue<T> implements QueueADT<T> {
	private int count;
	private LinearNode<T> front, rear;
	public LinkedQueue()
	{
		count = 0;
		front = rear = null;
	}
	public T dequeue() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		T result = front.getElement();
		front = front.getNext();
		count--;
		return result;
	}
	public void enqueue(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);
		if(isEmpty())
			front = node;
		else
			rear.setNext(node);
		rear = node;
		count++;
	}
	public T first() throws EmptyCollectionException {
 //... ...

	}
	public boolean isEmpty() {
		return true;
 //... ...
	}
	public int size() {
		return 0;
 //... ...
	}
	public String toString(){
		return "2";
 //... ...
	}
}