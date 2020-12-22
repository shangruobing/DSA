package Experiment_9;

/**
 * LinkedOrderedList represents a singly linked implementation of an
 * ordered list.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>
{
	/**
	 * Creates an empty list.
	 */
	public LinkedOrderedList()
	{
		super();
	}

	/**
	 * Adds the specified element to this list at the location determined by
	 * the element's natural ordering. Throws a NonComparableElementException
	 * if the element is not comparable.
	 *
	 * @param element the element to be added to this list
	 * @throws NonComparableElementException if the element is not comparable
	 */
	public void add(T element) {
		if (!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedOrderedList");

		Comparable<T> comparableElement = (Comparable<T>)element;
		LinearNode<T> current = head;
		LinearNode<T> previous = null;
		LinearNode<T> newNode  = new LinearNode<T>(element);
		boolean found = false;

		if (isEmpty())  // list is empty
		{
			head = newNode;
			tail = newNode;
		}
		else if (comparableElement.compareTo(head.getElement()) <= 0)
		// element goes in front
		{
			newNode.setNext(head);
			head = newNode;
		}
		else if (comparableElement.compareTo(tail.getElement()) >= 0)
		// element goes at tail
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		else  // element goes in the middle
		{
			while ((comparableElement.compareTo(current.getElement()) > 0))
			{
				previous = current;
				current = current.getNext();
			}

			newNode.setNext(current);
			previous.setNext(newNode);
		}

		count++;
	//	modCount++;
	}
}
