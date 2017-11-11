
public class SortedList<T extends Comparable<? super T>> extends DLList<T>  implements SortedListInterface<T> 
{
	public void add(T newEntry)
	{
		DLNode<T> tempNode = getHead();
		DLNode<T> node = new DLNode<T>();
		node.setEntry(newEntry);
		if(tempNode == null)
		{
			super.add(newEntry);
		}
		else
		{
			while(tempNode != null)
			{
				if(tempNode.getEntry().compareTo(node.getEntry()) <= 0)
				{
					if(tempNode.getPrev() == null)
					{
						node.setNext(tempNode);
						node.setPrev(null);
						tempNode.setPrev(node);
						setHead(node);
						break;
					}
					else
					{
						node.setNext(tempNode);
						node.setPrev(tempNode.getPrev());
						tempNode.getPrev().setNext(node);
						tempNode.setPrev(node);
						break;
					}	
				}
				else
				{
					tempNode = tempNode.getNext();
				}
				
			}
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
