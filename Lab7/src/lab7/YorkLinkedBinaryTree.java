package lab7;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name :
//Yorku Email :
//Date :
//Authenticity Declaration :
//I declare this submission is the result of my own work and has not been
//shared with any other student or 3rd party content provider.This submitted
//piece of work is entirely of my own creation.
//////////////////////////////
/*
* <p>
* Your implementation of this class or methods should not contains:
* 1. No System.out.println statements should appear here. Instead, you need to
* return the result. 2. No Scanner operations should appear here (e.g.,
* input.nextInt()). Instead, refer to the input parameters of this method.
* </p>
*/

/**
 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
 * preorder traversal algorithm to visit tree position or elements.
 * 
 * In a YorkLinkedBinaryTree tree, we adopt a convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to ensure 
 * that you have correct implementation of YorkLinkedBinaryTree tree. 
 * 
 *
 */
public class YorkLinkedBinaryTree<E> implements BinaryTree<E> {

	
	// -------------- nested Node Class ------------------
	protected static class Node<E> implements Position<E> {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		private E element; 
		private Node<E> parent; 
		private Node<E> left; 
		private Node<E> right; 
		//----------------------------
		
		/** 
		 * Constructs a node with the given element and neighbors. 
		 * */
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			// TODO: Your implementation of this method starts here

		}
	

		public Node<E> getParent() {
			// TODO: Your implementation of this method starts here
			return null;
		}

		public Node<E> getLeft() {
			// TODO: Your implementation of this method starts here
			return null;
		}

		public Node<E> getRight() {
			// TODO: Your implementation of this method starts here
			return null;
		} 

		public void setElement(E e) {
			// TODO: Your implementation of this method starts here
			
		}

		public void setParent(Node<E> parentNode) {
			// TODO: Your implementation of this method starts here
			
		}

		public void setLeft(Node<E> leftChild) {
			// TODO: Your implementation of this method starts here
			
		}

		public void setRight(Node<E> rightChild) {
			// TODO: Your implementation of this method starts here
			
		}

		@Override
		public E getElement() throws IllegalStateException {
			// TODO: Your implementation of this method starts here
			return null;			
			
		}

	}
	//---- end of nested Node class----------------------
	
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */
	
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> root;

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size;

	
	/**
	 * Constructs an empty tree
	 */
	public YorkLinkedBinaryTree() {
		// TODO: Your implementation of this method starts here

	}

	@Override
	public Position<E> root() {
		// TODO: Your implementation of this method starts here
		return null;
		
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;


	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return false;

	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return false;

	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return false;

	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return false;
		
	}
	
	/**
	 *  Places element e at the root of an empty tree and returns its new Position.
	 *  
	 * @param e element of root 
	 * @return  position of root 
	 * @throws IllegalStateException if the tree is not empty
	 */
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		// TODO: Your implementation of this method starts here
		 return null;

	}
	
	/**
	 * Compute the depth of any given valid position by returning the number of
	 * levels separating Position p from the root.
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the number of levels separating Position p from the root.
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	public int depth(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		 return -1;

	}

	/**
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the height of the subtree rooted at Position p.
	 * @throws IllegalArgumentException
	 */
	public int height(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		 return -1;


	}

	/**
	 * Return the height of this binary tree
	 * 
	 * @return the height of this binary tree
	 */
	public int height() {
		// TODO: Your implementation of this method starts here
		return -1;
		

	}	

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}

	
	/**
	 * insert as the left child of P to contain the element e, return the newly
	 * inserted node, 
	 * Creates a new left child of Position p storing element e; returns its  Position.
	 *  
	 * @param p  the position where the left child will be added 
	 * @param e  the element that will be added as the left child of position p
	 * @return  the Position of the newly added left child 
	 * @throws IllegalArgumentException if p is not a valid Position for this tree or 
	 * 									the given position has already a left child 
	 */
	public Position<E> insertLeft(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}
	

	/**
	 * insert as the right child of P to contain the element e, return the newly
	 * inserted node 
	 * @param p the position where the right child will be added
	 * @param e the element that will be added as the right child of position p
	 * @return the Position of the newly added right child
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 *                                  or the given position has already a right
	 *                                  child
	 */
	public Position<E> insertRight(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;
	}


	/**
	 * Replaces the element at Position p with element e and returns the old
	 * element.
	 *
	 * @param p the input Position need to be updated
	 * @param e the new element
	 * @return the old element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}
	
	/**
	 *  Remove position p if p has at most one child and return p's parent 
	 * 
	 * @param p  the input position that needs to be removed from the tree 
	 * @return    the parent of the removed position
	 * @throws IllegalArgumentException  if p is not a valid Position for this tree or 
	 * 										p has two children
	 */
	public Position<E> remove(Position<E> p) throws IllegalArgumentException {
		// TODO: Your implementation of this method starts here
		return null;

	}
	
	
	/**
	 * Attaches two sub-trees t1 and t2, respectively, as the left and right subtree
	 * of the leaf Position p. After you successfully added t1 and t2 to a new tree
	 * and became part of a big tree, the t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 a completely independent tree whose structure becomes the left
	 *           child of p
	 * @param t2 a completely independent tree whose structure becomes the right
	 *           child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 *                                  or p is not a leaf
	 * 
	 */
	public void attach(Position<E> p, YorkLinkedBinaryTree<E> t1, YorkLinkedBinaryTree<E> t2)
			throws IllegalArgumentException {

		// TODO: Your implementation of this method starts here
	}
	
	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return null;

	}

	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		return null;
		
	}
	 
}
