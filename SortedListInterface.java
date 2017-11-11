/*
 * An interface of an ADT LIST
 * 
 * @author Grant Okamoto
 * @version 1.0
 */
public interface SortedListInterface<T extends Comparable<? super T>>
{
	/*
	 * Add an entry to the end of the list
	 * The list size will be increased by 1, other entries will be unaffected
	 * @parameter entry (the object we added)
	 */
	public void add(T newEntry);
	
	/*
	 * Remove entry to a specified position
	 * The list size will be decreased by 1, all entries below the item will be affected
	 * @parameter position(the location of the item)
	 * @throws EmptyListException if the list is empty 
	 * @throws IndexOutOfBoundsException if either position < 1 or position > getLength() + 1
	 * return the object removed
	 */
	public T remove(int position);
	
	/*
	 * View a specific entry 
	 * @parameter position(the location of the item)
	 * @throws IndexOutOfBoundsException if either position < 1 or position > getLength() + 1
	 * return the item being viewed
	 */
	public T view(int position);
	
	/*
	 * Checks list if it contains the item
	 *@parameter specified item
     *returns true if contains specified item, else false
     */
	public boolean contains(T entry);
	
	/* 
	 *Detects whether this list is empty.
     *return True if the list is empty, or false otherwise. 
     */
	public boolean isEmpty();

	/*
	 *Gets the size of this list.
     *return The number of entries currently in the list. 
     */
	public int getSize();

	/*
	 *Removes all entries from this list.
	 *@throwsEmptyListException if the list is empty
	 */
	public void clear();
}