package Experiment_5;

public class CircularArrayQueue<T> implements QueueADT<T>{
	private final int DDFAULT_CAPACITY	=100;
	private int front, rear, count;
	private T[] queue;
	public CircularArrayQueue(){
		front = rear = count = 0;
		queue = (T[])( new Object[DDFAULT_CAPACITY]);
	}
	public CircularArrayQueue(int initialCapacity){
		front = rear = count = 0;
		queue = ((T[])new Object[initialCapacity]);
	}
	public T dequeue() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		T result = queue[front];
		queue[front]=null;
		front = (front+1)%queue.length;
		count--;
		return result;
	}
	public void enqueue(T element) {
		if (size()==queue.length)
			expandCapacity();
		queue[rear] = element;
		rear = (rear+1)%queue.length;
		count++;
	}
	public void expandCapacity()
	{
		T[] larger = (T[])(new Object[queue.length*2]);
		for (int scan=0;scan<count; scan++)
		{  larger[scan] =queue[front];
			front = (front+1)% queue.length;
		}
		front = 0;
		rear = count;
		queue = larger;
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
