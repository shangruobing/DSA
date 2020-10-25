package Experiment_4;

public class EmptyCollectionException extends RuntimeException {
	/**
	 * Sets up this exception with an appropriate(合适的) message.
	 * @param collection the name of the collection
	 */
	public EmptyCollectionException(String collection) {
		super("The " + collection + " is empty.");
	}
}
