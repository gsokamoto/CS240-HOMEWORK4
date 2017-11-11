/*
 * A node object for doubly linked double ended queue.
 * @author Grant Okamoto
 * @version 1.0
 * 
 */

public class DLNode<T> {
	
	private DLNode<T> prev;
	private T entry;
	private DLNode<T> next;
	
	public DLNode()
	{
		next = null;
		prev = null;
	}
	public void setPrev(DLNode<T> node)
	{
		prev = node;
	}
	public void setEntry(T newEntry)
	{
		entry = newEntry;
	}
	public void setNext(DLNode<T> node)
	{
		next = node;
	}
	public DLNode<T> getPrev()
	{
		return prev;
	}
	public T getEntry()
	{
		return entry;
	}
	public DLNode<T> getNext()
	{
		return next;
	}
}
