package edu.iastate.cs228.hw4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Extension of the AbstractCollection class based on a Binary Search Tree.
 * Efficiencies may vary by implementation, but all methods should have at
 * least the worst case runtimes of a standard Tree.
 * 
 * @author Sydney Ehlinger
 */
public class BinarySearchTree<E extends Comparable<? super E>> extends AbstractCollection<E> {

    /**
     * Member variables to support the tree: - A Node referencing the root of
     * the tree - An int specifying the element count
     */
	private Node<E> root;
	
	private int size;

    /**
     * Constructs an empty BinarySearchTree
     */
    public BinarySearchTree() {
    	root = null;
    	size = 0;
    }

    /**
     * Constructs a new BinarySearchTree whose root is exactly the given Node.
     * (For testing purposes, set the root to the given Node, do not clone it)
     * 
     * @param root
     *            - The root of the new tree
     * @param size
     *            - The number of elements already contained in the new tree
     */
    public BinarySearchTree(Node<E> root, int size) {
        this.root = root;
        this.size = size;
    }

    /**
     * Adds the given item to the tree if it is not already there.
     * 
     * @return false if item already exists in the tree and true otherwise.
     * @param item
     *            - Item to be added to the tree
     * @throws IllegalArgumentException
     *             - If item is null
     */
    @Override
    public boolean add(E item) throws IllegalArgumentException {
        if(item == null){
        	throw new IllegalArgumentException();
        }
        if(root == null){
        	root = new Node<E>(item);
            size++;
            return true;
        }
        Node<E> current = root;
        while(true){
        	int comp = current.getData().compareTo(item);
        	if(comp == 0){
        		return false;
        	}else if(comp > 0){
        		if(current.getLeft() != null){
        			current = current.getLeft();
        		}else{
        			current.setLeft(new Node<E>(item));
        			Node<E> left = current.getLeft();
        			left.setParent(current);
        			size++;
        			return true;
        		}
        	}else{
        		if(current.getRight() != null){
        			current = current.getRight();
        		}else{
        			current.setRight(new Node<E>(item));
        			Node<E> right = current.getRight();
        			right.setParent(current);
        			size++;
        			return true;
        		}
        	}
        }
    }

    /**
     * Removes the given item from the tree if it is there. Because the item 
     * is an Object it will need to be cast to an E type. To verify that this
     * is a safe cast, compare its class to the class of the root Node's data.
     * 
     * @return false if the list is empty or item does not exist in the tree,
     *         true otherwise
     * @param item
     *            - The item to be removed from the tree
     */
    @Override
    public boolean remove(Object item) {
        if(item != null){
	        if(contains(item)){
	        	E key = (E) item;
	        	unlinkNode(find(root, key));
	        	size--;
	        	return true;
	        }else{
	        	return false;
	        }
        }
        return false;
    }
    
    /**
     * Searches through the BinarySearchTree to find the node that contains the item, and returns the node
     * @param n
     * 	Starting node
     * @param item
     * 	Item to find
     * @return
     * 	Node that contains the item
     */
    private Node<E> find(Node<E> n, E item){
    	int comp = item.compareTo(n.getData());
    	if (comp == 0){
    		return n;
    	}
    	if (comp > 0){
    		return find(n.getRight(), item);
    	}
    	return find(n.getLeft(), item);
    }
    
    /**
     * Unlinks the node from the BinarySerchTree
     * @param n
     * 	Node to be unlinked
     */
    private void unlinkNode(Node<E> n){
    	//no children
    	if(n.getLeft() == null && n.getRight() == null){
    		if(n == n.getParent().getLeft()){
    			n = n.getParent();
    			n.setLeft(null);
    		}else{
    			n = n.getParent();
    			n.setRight(null);
    		}
    	}else if((n.getLeft() != null && n.getRight() == null) || (n.getLeft() == null && n.getRight() != null)){ // 1 child
    		if(n.getLeft() != null){
    			Node<E> child = n.getLeft();
    			n.setData(child.getData());
    			unlinkNode(child);
    		}else{
    			Node<E> child = n.getRight();
    			n.setData(child.getData());
    			unlinkNode(child);
    		}
    	}else{ //2 children
    		Node<E> suc = n.getSuccessor();
    		n.setData(suc.getData());
    		unlinkNode(suc);
    	}
    }

    /**
     * Retrieves data of the Node in the tree that contains item. i.e. the data
     * such that Node.data.equals(item) is true
     * 
     * @return null if item does not exist in the tree, otherwise the data
     *         stored at the Node that meets the condition above.
     * @param item
     *            - The item to be retrieved
     */
    public E get(E item) {
    	if(item == null){
    		throw new NullPointerException();
    	}else{
	        Node<E> current = root;
	        while(current != null){
	        	int comp = current.getData().compareTo(item);
	        	if(comp == 0){
	        		return current.getData();
	        	}
	        	if(comp > 0){
	        		current = current.getLeft();
	        	}else{
	        		current = current.getRight();
	        	}
	        }
    	}
        return null;
    }

    /**
     * Tests whether or not item exists in the tree. i.e. this should only
     * return true if a Node exists in the tree such that Node.data.equals(item)
     * is true
     * 
     * @return false if item does not exist in the tree, otherwise true
     * @param item
     *            - The item check
     */
    @Override
    public boolean contains(Object item) {
    	if(item != null && root != null){
    		if(root.getData().getClass().isAssignableFrom(item.getClass())){
		        E key = (E) item;
		        return get(key) != null;
    		}else{
    			return false;
    		}
    	}
    	return false;
    }

    /**
     * Removes all elements from the tree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Tests whether or not the tree contains any elements.
     * 
     * @return false if the tree contains at least one element, true otherwise.
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
        	return true;
        }
        return false;
    }

    /**
     * Retrieves the number of elements in the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a new BSTIterator instance.
     */
    @Override
    public Iterator<E> iterator() {
        return new BSTIterator();
    }

    /**
     * Returns an ArrayList containing all elements in the tree in the order
     * given by a preorder traversal of the tree.
     * 
     * @return an ArrayList of elements from the traversal.
     */
    public ArrayList<E> getPreorderTraversal() {
        ArrayList<E> list = new ArrayList<>();
        if(root == null){
        	return null;
        }
        preOrder(root, list);
        return list;
    }
    
    /**
     * Iterates through the BinarySearchTree in preOrder and appends them to the list
     * @param n
     * 	Starting node
     * @param list
     * 	List for nodes to be added to
     */
    private void preOrder(Node<E> n, ArrayList<E> list){
    	list.add(n.getData());
        if(n.getLeft() != null){
        	preOrder(n.getLeft(), list);
        }
        if(n.getRight() != null){
        	preOrder(n.getRight(), list);
        }
    }

    /**
     * Returns an ArrayList containing all elements in the tree in the order
     * given by a postorder traversal of the tree.
     * 
     * @return an ArrayList of elements from the traversal.
     */
    public ArrayList<E> getPostOrderTraversal() {
        ArrayList<E> list = new ArrayList<>();
        if(root == null){
        	return null;
        }
        postOrder(root, list);
        return list;
    }
    
    /**
     * Iterates through the BinarySearchTree in postOrder and appends them to the list
     * @param n
     * 	Starting node
     * @param list
     * 	List for nodes to be added to
     */
    private void postOrder(Node<E> n, ArrayList<E> list){
        if(n.getLeft() != null){
        	postOrder(n.getLeft(), list);
        }
        if(n.getRight() != null){
        	postOrder(n.getRight(), list);
        }
    	list.add(n.getData());
    }

    /**
     * Returns an ArrayList containing all elements in the tree in the order
     * given by a inorder traversal of the tree.
     * 
     * @return an ArrayList of elements from the traversal.
     */
    public ArrayList<E> getInorderTravseral() {
        ArrayList<E> list = new ArrayList<>();
        if(root == null){
        	return null;
        }
        inOrder(root, list);
        return list;
    }
    
    /**
     * Iterates through the BinarySearchTree in inOrder and appends them to the list
     * @param n
     * 	Starting node
     * @param list
     * 	List for nodes to be added to
     */
    private void inOrder(Node<E> n, ArrayList<E> list){
        if(n.getLeft() != null){
        	inOrder(n.getLeft(), list);
        }
    	list.add(n.getData());
        if(n.getRight() != null){
        	inOrder(n.getRight(), list);
        }
    }

    /**
     * Implementation of the Iterator interface which returns elements in the
     * order of an inorder traversal using Nodes predecessor and successor.
     * 
     * @author Sydney Ehlinger
     */
    private class BSTIterator implements Iterator<E> {

    	/**
    	 * node to be visited next
    	 */
        private Node<E> next;
        
        /**
         * node last visited by next()
         */
        private Node<E> last = null;

        /**
         * Constructor of iterator
         */
        public BSTIterator() {
        	next = root;
            if ( next != null ){
                while ( next.getLeft() != null ){
                	next = next.getLeft();
                }
            }
        }

        /**
         * Returns true if more elements exist in the inorder traversal, false
         * otherwise.
         */
        @Override
        public boolean hasNext() {
        	return next != null;
        }

        /**
         * Returns the next item in the inorder traversal.
         * 
         * @return the next item in the traversal.
         * @throws IllegalStateException
         *             - if no more elements exist in the traversal.
         */
        @Override
        public E next() throws IllegalStateException {
            if ( next == null ){
                throw new IllegalStateException();
            }  
               last = next;
               next = next.getSuccessor();
               return last.getData();
        }

        /**
         * Removes the last item that was returned by calling next().
         * 
         * @throws IllegalStateException
         *             - if next() has not been called yet or remove() is called
         *             multiple times in a row.
         */
        @Override
        public void remove() throws IllegalStateException {
            if ( last == null ){
                throw new IllegalStateException();
            }
            if ( last.getLeft() != null && last.getRight() != null ){
                next = last;
                unlinkNode(next);
            }else{
            	unlinkNode(last);
            }
            last = null;
            size--;
        }

    }
}