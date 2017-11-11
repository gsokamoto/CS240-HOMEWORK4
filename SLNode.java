
/*
 * A node object for singly linked double ended queue.
 * @author Grant Okamoto
 * @version 1.0
 * 
 */

public class SLNode<T> {
	
	private SLNode<T> next;
	private T entry;
	
	public SLNode()
	{
		next = null;
	}
	public void setNext(SLNode<T> node)
	{
		next = node;
	}
	public void setEntry(T newEntry)
	{
		entry = newEntry;
	}
	public SLNode<T> getNext()
	{
		return next;
	}
	public T getEntry()
	{
		return entry;
	}
}
