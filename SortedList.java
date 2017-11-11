
public class SortedList<T extends Comparable<? super T>> extends DLList<T>  implements SortedListInterface<T> 
{
	public void add(T newEntry)
	{
		DLNode<T> tempNode = getHead();
		DLNode<T> node = new DLNode<T>();
		node.setEntry(newEntry);
		//if the list is empty adds a new entry
		if(tempNode == null)
		{
			super.add(newEntry);
		}
		else
		{
			while(tempNode != null)
			{
				//checks if first entry is bigger than second entry
				if(tempNode.getEntry().compareTo(node.getEntry()) <= 0)
				{
					//adds to the head
					if(tempNode.getPrev() == null)
					{
						node.setNext(tempNode);
						node.setPrev(null);
						tempNode.setPrev(node);
						setHead(node);
						break;
					}
					//adds to anywhere else
					else
					{
						node.setNext(tempNode);
						node.setPrev(tempNode.getPrev());
						tempNode.getPrev().setNext(node);
						tempNode.setPrev(node);
						break;
					}	
				}
				//moves to next node
				else
				{
					tempNode = tempNode.getNext();
				}
			}
			//adds node to the front if its the smallest entry
			if(tempNode == null)
			{
				tempNode = getTail();
				node.setNext(null);
				node.setPrev(tempNode);
				tempNode.setNext(node);
				setTail(node);
			}
			setSize(getSize() + 1);
		}
	}
}
