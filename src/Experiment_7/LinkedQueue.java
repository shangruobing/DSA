package Experiment_7;

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
	public T first() throws EmptyCollectionException{
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		else
			return front.getElement();
		}

	public boolean isEmpty() {
		if(count==0)
			return true;
		else
			return false;

		//return front==rear;
	}
	public int size() {
		return count;

	}
	public String toString(){
		LinearNode<T> store; //用于储存front的初始值
		String result;
		result="";
		store=front;
		for (int i=0;i<count;i++){
			result+=front.getElement()+" ";
			if (front.getNext()!=null)
				front = front.getNext();
			System.out.println(front);
		}
		front=store;
		return result;
	}

}