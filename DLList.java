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
			if(isEmpty())
			{
				node.setPrev(null);
				tail = node;
			}
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
			
			while(position < size)
			{
				tempNode = tempNode.getNext();
				position++;
			}
			tempEntry = tempNode.getEntry();
			if(tempNode.getNext() == null)
			{
				tempNode.getPrev().setNext(null);
				tail = tempNode.getPrev();
			}
			else if(tempNode.getPrev() == null)
			{
				tempNode.getNext().setPrev(null);
				head = tempNode.getNext();
			}
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
			if(tempNode == null)
			{
				return false;
			}
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
