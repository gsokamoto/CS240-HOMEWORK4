public class DLList<T> implements ListInterface<T> 
	{
		private DLNode<T> head;
		private DLNode<T> tail;
		private int size;
		
		public DLList()
		{
			head = null;
			tail = null;
			size = 0;
		}

		public void add(T newEntry) 
		{
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			node.setNext(head);
			//adds to empty list
			if(isEmpty())
			{
				node.setPrev(null);
				tail = node;
			}
			//adds to a list with at least 1 entry
			else
			{
				head.setPrev(node);
				node.setPrev(null);
			}
			head = node;
			size++;
		}

		public void add(int position, T newEntry)
		{
			
			if(position < 0 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
			
			DLNode<T> tempNode = head;
			DLNode<T> node = new DLNode<T>();
			node.setEntry(newEntry);
			
			//if it is the first entry, adds the entry in front of the position
			if(position == 1)
			{
				tail.setNext(node);
				node.setNext(null);
				node.setPrev(tail);
				tail = node;
			}
			else
			{
				while(position < size)
				{
					tempNode = tempNode.getNext();
					position++;
				}
				node.setNext(tempNode.getNext());
				tempNode.getNext().setPrev(node);
				tempNode.setNext(node);
				node.setPrev(tempNode);
			}
			size++;
		}

		public T remove(int position)
		{

			if(position < 1 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
			DLNode<T> tempNode = head;
			T tempEntry;
			//moves pointer
			while(position < size)
			{
				tempNode = tempNode.getNext();
				position++;
			}
			tempEntry = tempNode.getEntry();
			//removes the first entry
			if(tempNode.getNext() == null)
			{
				tempNode.getPrev().setNext(null);
				tail = tempNode.getPrev();
			}
			//removes the last entry
			else if(tempNode.getPrev() == null)
			{
				tempNode.getNext().setPrev(null);
				head = tempNode.getNext();
			}
			//removes any entry that isn't last or first
			else
			{
				tempNode.getNext().setPrev(tempNode.getPrev());
				tempNode.getPrev().setNext(tempNode.getNext());
			}
			size--;
			return tempEntry;
		}

		public T replace(int position, T newEntry) 
		{
			if(position < 1 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
			T tempEntry;
			//adds and removes entry at same position
			if(position == size)
			{
				tempEntry = remove(position);
				add(newEntry);
			}
			//this one can only remove and add from any location other than the last entry on the list
			else
			{
				tempEntry = remove(position);
				add(position, newEntry);
			}
			return tempEntry;
		}

		public T view(int position) 
		{
			if(position < 1 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
			DLNode<T> tempNode = head;
			while(position < size)
			{
				tempNode = tempNode.getNext();
				position++;
			}
			return tempNode.getEntry();
		}

		public boolean contains(T entry) 
		{
			
			DLNode<T> tempNode = head;
			//returns false if empty
			if(tempNode == null)
			{
				return false;
			}
			//checks all node except the first node
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
			//checks the first node
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
		
		//be sure to take out sys out print on DL and SL list
		public T[] toArray() 
		{
			if(isEmpty())
			{
				throw new EmptyListException("Error. The list is empty.");
			}
			@SuppressWarnings("unchecked")
			T[] arrayList = (T[]) new Object[size - 1];
			DLNode<T> tempNode = head;
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
		
		//these methods are for sorted list
		public DLNode<T> getHead()
		{
			return head;
		}
		public void setHead(DLNode<T> newHead)
		{
			head = newHead;
		}
		public DLNode<T> getTail()
		{
			return tail;
		}
		public void setTail(DLNode<T> newTail)
		{
			tail = newTail;
		}
		public void setSize(int newSize)
		{
			size = newSize;
		}
	}
