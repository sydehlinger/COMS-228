package edu.iastate.cs228.hw3;

/*
 * @author Sydney Ehlinger
 */

//make helper methods private

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the list interface based on linked nodes
 * that store multiple items per node. Rules for adding and removing
 * elements ensure that each node (except possibly the last one)
 * is at least half full.
 *
 * A link to the JavaDoc documentation for the interface AbstractSequentialList<E>
 * is provided next to the pdf spec on Blackboard.
 *
 * You should carefully study the complete methods given below
 * to learn how to go about implementing other methods.
 *
 * You are encouraged to introduce private methods that can be used to
 * simplify the implementation of public methods.
 */
public class ChunkyList<E extends Comparable<? super E>> extends AbstractSequentialList<E>
{
  /**
   * Default number of elements that may be stored in each node.
   */
  private static final int DEFAULT_NODESIZE = 4;
  
  /**
   * Number of elements that can be stored in each node.
   */
  private final int nodeSize;
  
  /**
   * Dummy node for head.  It should be private but set to public here only  
   * for grading purpose.  In practice, you should always make the head of a 
   * linked list a private instance variable.  
   */
  public Node head;
  
  /**
   * Dummy node for tail.
   */
  private Node tail;
  
  /**
   * Number of elements in the list.
   */
  private int size;
  
  /**
   * Constructs an empty list with the default node size.
   */
  public ChunkyList()
  {
    this(DEFAULT_NODESIZE);
  }

  /**
   * Constructs an empty list with the given node size.
   * @param nodeSize number of elements that may be stored in each node, must be 
   *   an even number
   */
  public ChunkyList(int nodeSize)
  {
    if (nodeSize <= 0 || nodeSize % 2 != 0) throw new IllegalArgumentException();
    
    // dummy nodes
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.previous = head;
    this.nodeSize = nodeSize;
  }
  
  /**
   * Constructor for grading only.  Fully implemented. 
   * @param head
   * @param tail
   * @param nodeSize
   * @param size
   */
  public ChunkyList(Node head, Node tail, int nodeSize, int size)
  {
	  this.head = head; 
	  this.tail = tail; 
	  this.nodeSize = nodeSize; 
	  this.size = size; 
  }

  /**
   * Returns the number of elements in the the ChunkyList
   */
  @Override
  public int size()
  {
	  return size;
  }
  
  /**
   * Adds item at the end of the ChunkyList, creates another node if needed
   * @param item
   * 	item to be added to the ChunkyList
   */
  @Override
  public boolean add(E item)
  {
	  if(item == null){
		  throw new NullPointerException();
	  }
	  if(size == 0){
		  Node temp = new Node();
		  temp.addItem(item);
		  if(head != null){
			  head.next = temp;
			  temp.previous = head;
			  tail.previous = temp;
			  temp.next = tail;
		  }
	  }else{
		  Node cursor = tail.previous;
		  if(cursor.count < nodeSize){
			  cursor.addItem(item);
		  }else{
			  Node temp = new Node();
			  temp.addItem(item);
			  if(head != null){
				  cursor.next = temp;
				  temp.previous = cursor;
				  tail.previous = temp;
				  temp.next = tail;
			  }
		  }
	  }
	  size++;
	  return true;
  }

  /**
   * Adds item to a specific position in the ChunkyList, also splits array accordingly
   * @param pos
   * 	position for the item to be placed
   * @param item
   * 	item to be added to the ChunkyList
   */
  @Override
  public void add(int pos, E item)
  {
	  if(item == null){
		  throw new NullPointerException();
	  }
	  if(pos > size){
		  throw new IndexOutOfBoundsException();
	  }
	  if(size == 0){
		  Node temp = new Node();
		  temp.addItem(item);
		  if(head != null){
			  head.next = temp;
			  temp.previous = head;
			  tail.previous = temp;
			  temp.next = tail;
		  }
	  }else if(pos > nodeSize || pos % nodeSize == 0){
		  if(head.next.count == nodeSize && pos < nodeSize){
			  Node cursor = head.next;
			  Node temp = new Node();
			  int index = 0;
			  for(int i = nodeSize / 2; i < nodeSize; i++){
				  temp.addItem(index, cursor.data[i]);
				  index++;
			  }
			  for(int i = nodeSize / 2; i < nodeSize; i++){
				  cursor.removeItem(i);
			  }
			  cursor.addItem(pos, item);
			  if(head != null){
				  temp.next = cursor.next;
				  cursor.next = temp;
				  head.next = cursor;
			  }
		  }else{
			  Node cursor = tail.previous;
			  if(cursor.count < nodeSize){
				  cursor.addItem(pos % nodeSize, item);
			  }else{
				  Node temp = new Node();
				  temp.addItem(pos % nodeSize, item);
				  if(head != null){
					  cursor.next = temp;
					  temp.previous = cursor;
					  tail.previous = temp;
					  temp.next = tail;
				  }
			  } 
		  }
	  }else if(head.next.count == nodeSize){
		 if(pos <= nodeSize / 2){
			 Node cursor = head.next;
				  Node temp = new Node();
				  int index = 0;
				  for(int i = nodeSize / 2; i < nodeSize; i++){
					  temp.addItem(index, cursor.data[i]);
					  index++;
				  }
				  for(int i = nodeSize / 2; i < nodeSize; i++){
					  cursor.removeItem(i);
				  }
				  cursor.addItem(pos, item);
				  if(head != null){
					  temp.next = cursor.next;
					  cursor.next = temp;
					  head.next = cursor;
				  }
		 }else if(pos > nodeSize / 2){
			 Node cursor = head.next;
			 Node temp = new Node();
			 int index = 0;
			 for(int i = nodeSize / 2; i < nodeSize; i++){
				 temp.addItem(index, cursor.data[i]);
				 index++;
			 }
			 for(int i = nodeSize / 2; i < nodeSize; i++){
				 cursor.removeItem(i);
			 }
			 temp.addItem(pos - nodeSize / 2, item);
			 if(head != null){
				 temp.next = cursor.next;
				 cursor.next = temp;
				 head.next = cursor;
			 }
		}
	  }else{
		  head.next.addItem(pos, item);
	  }
	  size++;
  }

  /**
   * Removes element from ChunkyList at a certain position
   * @param pos
   * 	Position of element to be removed
   */
  @Override
  public E remove(int pos)
  {
	  E ret = null;
	  Node cursor = head.next;
	  if(pos >= nodeSize){
		  cursor = cursor.next;
		  ret = cursor.data[pos % nodeSize];
		  cursor.removeItem(pos % nodeSize);
	  }else if(pos < nodeSize){
		  ret = cursor.data[pos];
		  cursor.removeItem(pos);
	  }
	  return ret;
  }

  /**
   * Removes each element (from the list) that is equal to an element in an array arr[].
   * You should use an efficient algorithm to implement this method.
   * One efficient implementation is given as follows.
   * Sort the array arr[] with Arrays.sort().
   * Use a ListIterator object to access each element in this list.
   * If the element is found in the array arr[] with Arrays.binarySearch(),
   * then remove the element from the list.
   * 
   * @param arr   array of (unsorted) elements
   */
  public void removeAll(E[] arr)
  {
	  int length = size;
	  Arrays.sort(arr);
	  ListIterator<E> iter = this.listIterator();
	  while(length != 0){
		  E element = iter.next();
		  if(Arrays.binarySearch(arr, element) >= 0){
			  iter.remove();
			  size--;
		  }
			  length--;
	  }
  }

  /**
   * Iterator through the ChunkyList (only goes forward)
   */
  @Override
  public Iterator<E> iterator()
  {
	Iterator<E> test = new ChunkyListIterator();
    return test;
  }

  /**
   * ListIterator through the ChunkyList (goes forward and backward)
   */
  @Override
  public ListIterator<E> listIterator()
  {
	  ListIterator<E> test = new ChunkyListIterator();
	  return test;
  }

  /**
   * ListIterator through the ChunkyList, but starts at a specific index
   * @param index
   * 	Starting index of ListIterator
   */
  @Override
  public ListIterator<E> listIterator(int index)
  {
	ChunkyListIterator test = new ChunkyListIterator(index);
    return test;
  }
  
  /**
   * Returns a string representation of this list showing
   * the internal structure of the nodes.
   */
  public String toStringInternal()
  {
    return toStringInternal(null);
  }

  /**
   * Returns a string representation of this list showing the internal
   * structure of the nodes and the position of the iterator.
   *
   * This complete example illustrates how a method in this data structure
   * is implemented. You should study this code carefully and use this method
   * to show the contents of the list every time you implement and use a new method.
   *
   * @param iter   an iterator for this list
   */
  public String toStringInternal(ListIterator<E> iter) 
  {
      int count = 0;
      int position = -1;
      if (iter != null) {
          position = iter.nextIndex();
      }

      StringBuilder sb = new StringBuilder();
      sb.append('[');
      Node current = head.next;
      while (current != tail) {
          sb.append('(');
          for (int i = 0; i < nodeSize; ++i) {
              if ( i > 0 )
                   sb.append(", ");
              E data = current.data[i];
              if (data == null) {
                  sb.append("-");
              } else {
                  if (position == count) {
                      sb.append("| ");
                      position = -1;
                  }
                  sb.append(data.toString());
                  ++count;

                  // iterator at end
                  if (position == size && count == size) {
                      sb.append(" |");
                      position = -1;
                  }
             }
          }
          sb.append(')');
          current = current.next;
          if (current != tail)
              sb.append(", ");
      }
      sb.append("]");
      return sb.toString();
  }

  /**
   * Node type for this list.  Each node holds a maximum
   * of nodeSize elements in an array.  Empty slots
   * are null.
   */
  private class Node
  {
    /**
     * Array of actual data elements.
     */
    // Unchecked warning unavoidable.
    public E[] data = (E[]) new Comparable[nodeSize];
    
    /**
     * Link to next node.
     */
    public Node next;
    
    /**
     * Link to previous node;
     */
    public Node previous;
    
    /**
     * Index of the next available offset in this node, also 
     * equal to the number of elements in this node.
     */
    public int count;

    /**
     * Adds an item to this node at the first available offset.
     * Precondition: count < nodeSize
     * @param item element to be added
     */
    void addItem(E item)
    {
      if (count >= nodeSize)
      {
        return;
      }
      data[count++] = item;
      //useful for debugging
//            System.out.println("Added " + item.toString() + " at index " + count + " to node "  + Arrays.toString(data));
    }
  
    /**
     * Adds an item to this node at the indicated offset, shifting
     * elements to the right as necessary.
     * 
     * Precondition: count < nodeSize
     * @param offset array index at which to put the new element
     * @param item element to be added
     */
    void addItem(int offset, E item)
    {
      if (count >= nodeSize)
      {
    	  return;
      }
      for (int i = count - 1; i >= offset; --i)
      {
        data[i + 1] = data[i];
      }
      ++count;
      data[offset] = item;
      //useful for debugging 
//      System.out.println("Added " + item.toString() + " at index " + offset + " to node: "  + Arrays.toString(data));
    }

    /**
     * Deletes an element from this node at the indicated offset, 
     * shifting elements left as necessary.
     * Precondition: 0 <= offset < count
     * @param offset
     */
    void removeItem(int offset)
    {
      E item = data[offset];
      for (int i = offset + 1; i < nodeSize; ++i)
      {
        data[i - 1] = data[i];
      }
      data[count - 1] = null;
      --count;
    }    
  }
 
  /**
   * ChunkyListIterator class contains constructors for the iterators and methods to act upon the iterators
   */
  private class ChunkyListIterator implements ListIterator<E>
  {
	  /**
	   * Copy of the ChunkyList
	   */
	  private Node cursor;
	  
	  /**
	   * Keeps track of the internal index of a node in a ChunkyList
	   */
	  private int index;
	  
	  /**
	   * Keeps track of the nextIndex of the iterator
	   */
	  private int nextIndex;
	  
	  /**
	   * Stores item to be returned by next() and previous()
	   */
	  private E ret;
	  
	  /**
	   * Stores integer value to keep track of what has been just called: 1 for next(), -1 for previous(), 0 for add() and remove()
	   */
	  private int justCalled;
	  
    /**
     * Default constructor 
     */
    public ChunkyListIterator()
    {
    	cursor = head;
    }

    /**
     * Constructor finds node at a given position.
     * @param pos
     */
    public ChunkyListIterator(int pos)
    {
    	if(pos > size){
    		throw new IndexOutOfBoundsException();
    	}
    	cursor = head;
    	nextIndex = pos;
    	if(pos >= nodeSize){
    		index = pos % nodeSize;
    		cursor = cursor.next;
    	}else{
    		index = pos;
    	}
    }

    /**
     * Checks if the node has a value in the next position
     */
    @Override
    public boolean hasNext()
    {
    	if(index <= nodeSize - 1){
    		if(cursor.next.data[index] == null && cursor.next.next.count != 0){
    			cursor = cursor.next;
    			index = 0;
    		}
    		return cursor.next.data[index] != null;
    	}
		cursor = cursor.next;
		index = 0;
		return cursor.next.data[index] != null;
    }

    /**
     * Returns value in the next position in the node
     */
    @Override
    public E next()
    {
    	E ret = null;
    	if(!hasNext()){
    		throw new NoSuchElementException();
    	}
    	if(index < nodeSize){
    		ret = cursor.next.data[index];
    		index++;
    		nextIndex++;
    	}else{
    		cursor = cursor.next;
    		index = 0;
    		ret = cursor.next.data[index];
    		index++;
    		nextIndex++;
    	}
    	justCalled = 1;
    	return ret;
    }

    /**
     * Removes element based off of position of the iterator and collapses the ChunkyList accordingly
     */
    @Override
    public void remove()
    {
    	if(justCalled == 0){
    		throw new IllegalStateException();
    	//next
    	}else if(justCalled == 1){
    		cursor.next.removeItem(index - 1);
        	nextIndex--;
    	//previous	
    	}else if(justCalled == -1){
    		if(nextIndex > nodeSize){
    			cursor = cursor.next;
    		}
    		cursor.next.removeItem(index);
    	}
    	//collapse
    	if(cursor.count < nodeSize / 2 && cursor.count != 0){
    		if(cursor.next.count <= nodeSize / 2){
    			for(int i = 0; i < nodeSize / 2; i++){
    				if(cursor.data[index - 1] == null){
    					cursor.addItem(index - 1, cursor.next.data[i]);
    				}else{
    					cursor.addItem(index, cursor.next.data[i]);
    				}
    				index++;
    			}
    			for(int i = 0; i < nodeSize / 2; i++){
    				cursor.next.removeItem(i);
    			}
    			if(head != null){
    				cursor.next = tail;
    			}
    		}else{
    			if(cursor.data[index - 1] == null){
    				cursor.addItem(index - 1, cursor.next.data[0]);
				}else{
					cursor.addItem(index, cursor.next.data[0]);
				}
    			index++;
    			cursor.next.removeItem(0);
    		}
    	}else if(cursor.count == 0 && cursor.next.count < nodeSize / 2){
				if(cursor.next.next.count > nodeSize / 2){
					if(cursor.next.data[index - 1] == null){
						cursor.next.addItem(index - 1, cursor.next.next.data[0]);
					}else{
						cursor.next.addItem(index, cursor.next.next.data[0]);
					}
					cursor.next.next.removeItem(0);
				}else if(cursor.next.next.count == nodeSize / 2){
					if(cursor.next.data[index - 1] == null){
						cursor.next.addItem(index - 1, cursor.next.next.data[0]);
					}else{
						cursor.next.addItem(index, cursor.next.next.data[0]);
					}
					index++;
					cursor.next.next.removeItem(0);
				}
				if(cursor.next.next.count < nodeSize / 2){
					if(cursor.next.data[index - 1] == null){
							cursor.next.addItem(index - 1, cursor.next.next.data[0]);
					}else{
							cursor.next.addItem(index, cursor.next.next.data[0]);
					}
					cursor.next.next.removeItem(0);
				}
			index++;
		    if(cursor.count == 0 & cursor.next.next.count == 0){
		    	head.next.next = tail;
		    }
		}
    	if(cursor.count == 0 & cursor.next.count == 0){
    		head.next = tail;
    	}
    	index--;
    	size--;
    	justCalled = 0;
    }

    /**
     * Adds element based off of position of the iterator and splits the ChunkyList accordingly
     */
    @Override
    public void add(E item)
    {
    	if(cursor.next.count == nodeSize){
    		Node cursor = head.next;
			Node temp = new Node();
			int index = 0;
			for(int i = nodeSize / 2; i < nodeSize; i++){
				temp.addItem(index, cursor.data[i]);
				index++;
			}
			for(int i = nodeSize / 2; i < nodeSize; i++){
				cursor.removeItem(i);
			}
			cursor.addItem(nextIndex, item);
			if(head != null){
				temp.next = cursor.next;
				cursor.next = temp;
				head.next = cursor;
			}
    	}else{
    		cursor.next.addItem(nextIndex % nodeSize, item);
    	}
    	nextIndex++;
    	size++;
    	justCalled = 0;
    }

    /**
     * Checks if the node has a value in the previous position
     */
    @Override
    public boolean hasPrevious()
    {
    	boolean test = false;
    	if(index == 0){
    		if(nextIndex == 0){
    			return false;
    		}
    		cursor = cursor.previous;
    		index = nodeSize;
    		if(cursor.data == head.next.data){
    			ret = cursor.data[index - 1];
        		test = cursor.data[index - 1] != null;
        		if(test){
    		        index--;
    		        nextIndex--;
        		}
        		return test;
    		}
    		ret = cursor.next.data[index - 1];
    		test = cursor.next.data[index - 1] != null;
    		if(test){
		        index--;
		        nextIndex--;
    		}
    		return test;
    	}else if(index == nodeSize && nextIndex == nodeSize){
    		if(cursor.data == head.next.data){
        		ret = cursor.data[index - 1];
        		test = cursor.data[index - 1] != null;
        		if(test){
    		        index--;
    		        nextIndex--;
        		}
        		return test;
    		}
    		cursor = cursor.next;
    		ret = cursor.data[index - 1];
    		test = cursor.data[index - 1] != null;
    		if(test){
		        index--;
		        nextIndex--;
    		}
    		return test;
    	}
    	if(nextIndex > nodeSize){
    		if(cursor.previous.count == 0){
    			ret = cursor.next.data[index - 1];
    			test = cursor.next.data[index - 1] != null;
        		if(test){
    		        index--;
    		        nextIndex--;
        		}
        		return test;
    		}
    		ret = cursor.data[index - 1];
    		test = cursor.data[index - 1] != null;
    		if(test){
		        index--;
		        nextIndex--;
    		}
    		return test;
    	}
    	ret = cursor.next.data[index - 1];
    	test = cursor.next.data[index - 1] != null;
		if(test){
	        index--;
	        nextIndex--;
		}
		return test;
    }

    /**
     * Returns the next index of the iterator
     */
    @Override
    public int nextIndex()
    {
    	return nextIndex;
    }

    /**
     * Returns value in the previous position in the node
     */
    @Override
    public E previous()
    {
    	if(!hasPrevious()){
    		throw new NoSuchElementException();
    	}
    	justCalled = -1;
    	return ret;
    }

    /**
     * Returns the previous index
     */
    @Override
    public int previousIndex()
    { 
    	nextIndex -= 1;
        return nextIndex;
    }

    /**
     * Sets value according to the position of the iterator 
     * @param item
     * 	item to be set
     */
    @Override
    public void set(E item)
    {
    	if(justCalled == 1){
    		cursor.next.data[index - 1] = item;
    	}else if(justCalled == -1){
    		cursor.next.data[index] = item;
    	}else{
    		throw new IllegalStateException();
    	}
    }

  }

}
