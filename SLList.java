public class SLList<T> implements ListInterface<T>
{
	private SLNode<T> head;
	private int size;
	
	public SLList()
	{
		head = null;
		size = 0;
	}

	public void add(T newEntry) 
	{
		SLNode<T> node = new SLNode<T>();
		node.setEntry(newEntry);
		node.setNext(head);
		head = node;
		size++;
	}

	public void add(int position, T newEntry) 
	{
		if(position < 1 || position > size)
		{
			throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
		}
		
		SLNode<T> tempNode = head;
		SLNode<T> tempNode2 = head;
		SLNode<T> node = new SLNode<T>();
		node.setEntry(newEntry);
		
		if(position == 1)
		{
			while(tempNode.getNext() != null)
			{
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(node);
			node.setNext(null);
		}
		else
		{
			while(position < size)
			{
				tempNode = tempNode.getNext();
				tempNode2 = tempNode2.getNext();
				position++;
			}
			tempNode = tempNode.getNext();
			tempNode2.setNext(node);
			node.setNext(tempNode);
		}
		size++;
	}

	public T remove(int position)
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		if(position < 1 || position > size)
		{
			throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
		}
		SLNode<T> tempNode = head;
		SLNode<T> tempNode2 = head;
		T tempEntry;
		if(position == size)
		{
			tempEntry = head.getEntry();
			head = head.getNext();
		}
		else
		{
			while(position + 1 < size)
			{
				tempNode = tempNode.getNext();
				tempNode2 = tempNode2.getNext();
				position++;
			}
			tempNode = tempNode.getNext();
			tempEntry = tempNode.getEntry();
			tempNode2.setNext(tempNode.getNext());
		}
		size--;
		return tempEntry;
	}

	public T replace(int position, T newEntry) 
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		if(position < 1 || position > size)
		{
			throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
		}
		T tempEntry;
		if(position == size)
		{
			tempEntry = remove(position);
			add(newEntry);
		}
		else
		{
			tempEntry = remove(position);
			add(position, newEntry);
		}
		return tempEntry;
	}
	public T view(int position) 
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		if(position < 1 || position > size)
		{
			throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
		}
		SLNode<T> tempNode = head;
		while(position < size)
		{
			tempNode = tempNode.getNext();
			position++;
		}
		return tempNode.getEntry();
	}

	public boolean contains(T entry) 
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		SLNode<T> tempNode = head;
		while(tempNode.getNext() != null)
		{
			if(tempNode.getEntry() == entry)
			{
				return true;
			}
			else
			{
				tempNode = tempNode.getNext();
			}
		}
		if(tempNode.getNext() == null)
		{
			if(tempNode.getEntry() == entry)
			{
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() 
	{
		return head == null;
	}

	public int getSize() 
	{
		return size;
	}

	public T[] toArray() 
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		@SuppressWarnings("unchecked")
		T[] arrayList = (T[]) new Object[size - 1];
		SLNode<T> tempNode = head;
		int counter = size - 1;
		while(counter >= 0)
		{
			arrayList[counter] = tempNode.getEntry();
			tempNode = tempNode.getNext();
			counter--;
		}
		for(int i = 0; i < size; i++)
		{
			System.out.println(arrayList[i]);
		}
		return arrayList;
	}

	public void clear() 
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		while(head.getNext() != null)
		{
			remove(size);
			size--;
		}
		remove(size);
	}

}
