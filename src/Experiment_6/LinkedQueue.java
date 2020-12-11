package Experiment_6;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueADT<T> {
	private int count;
	private LinearNode<T> front, rear;

	public LinkedQueue() {
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

	public void enqueue(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		if (isEmpty())
			front = node;
		else
			rear.setNext(node);
		rear = node;
		count++;
	}

	public T first() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		else
			return front.getElement();
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public String toString() {
		LinearNode<T> store; //用于储存front的初始值
		String result;
		result = " ";
		store = front;
		for (int i = 0; i < count; i++) {
			result += front.getElement().toString() + " ";
			if (front.getNext() != null)
				front = front.getNext();
			//System.out.println(front.getElement());
		}
		front = store;
		return result;
	}

	public Iterator<T> iterator() {
		return new iterator();
	}

	private class iterator implements Iterator {
		int iteratorCount;
		LinearNode<T> current;

		public iterator() {
			//构造函数，当前位置指向首节点，迭代器元素个数等于容器内元素个数
			iteratorCount = count;
			current = front;
		}

		public boolean hasNext() throws ConcurrentModificationException {
			//如果迭代器还有一个以上元素时返回true
			if (iteratorCount != count)
				throw new ConcurrentModificationException();
			return (current != null);

		}

		public T next() throws ConcurrentModificationException {
			//返回迭代器中下一个元素，如果迭代器空则抛出异常
			if (!hasNext())
				throw new NoSuchElementException();

			T result = current.getElement();
			current = current.getNext();
			return result;
		}

		public void remove() throws UnsupportedOperationException {
			//在本容器内不支持remove方法，一旦调用，则抛出异常
			throw new UnsupportedOperationException();
		}
	}
}
