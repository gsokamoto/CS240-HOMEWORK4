public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>{

	private SLNode<T> head;
	private SLNode<T> tail;
	private int size;
	
	public PriorityQueue()
	{
		head = null;
		tail = null;
		size = 0;
	}
	public void add(T newEntry) 
	{
		SLNode<T> node = new SLNode<T>();
		node.setEntry(newEntry);
		//runs if empty queue
		if(isEmpty())
		{
			node.setNext(head);
			head = node;
			tail = node;
		}
		//runs if queue has only 1 entry
		else
		{
			SLNode<T> tempNode = head;
			if(tempNode.getNext() == null)
			{
				if(tempNode.getEntry().compareTo(newEntry) > 0)
				{
					node.setNext(tempNode);
					head = node;
				}
				else if(tempNode.getEntry().compareTo(newEntry) < 0)
				{
					node.setNext(null);
					tempNode.setNext(node);
					head = tempNode;
					tail = node;
				}
			}
			//runs if more than 1 entry
			else{
				while(true)
				{
					if(tempNode.getNext() == null)
					{
						node.setNext(null);
						tempNode.setNext(node);
						tail = node;
						break;
					}
					else if(tempNode.getNext().getEntry().compareTo(newEntry) >= 0)
					{
						if(head == tempNode)
						{
							node.setNext(tempNode);
							head = node;
							break;
						}
						else if(tempNode.getEntry().compareTo(newEntry) >= 0)
						{
							tempNode.setNext(node);
							tempNode = tempNode.getNext();
							node.setNext(tempNode);
							break;
						}
						else
						{
							tempNode = tempNode.getNext();
						}
						
					}
					else
					{
						tempNode = tempNode.getNext();
					}
				}
			}
			
		}
		size++;	
	}

	public T remove() 
	{
		if(isEmpty())
		{
			return null;
		}
		else{
			T tempEntry = tail.getEntry();
			SLNode<T> tempNode = head;
			if(tempNode.getNext() == null)
			{
				head = null;
				tail = null;
			}
			else{
				while(tempNode.getNext().getNext() != null)
				{
					tempNode = tempNode.getNext();
				}
				tempNode.setNext(null);
				tail = tempNode;
			}
			size--;
			return tempEntry;
		}
	}

	public T peek()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return tail.getEntry();
		}
	}

	public boolean isEmpty() 
	{
		if(tail == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getSize() 
	{
		return size;
	}

	public void clear() 
	{
		while(!isEmpty())
		{
			remove();
		}
	}
	
}
