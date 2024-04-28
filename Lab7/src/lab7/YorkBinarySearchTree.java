package lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
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
 * The YorkBinarySearchTree tree is an binary search tree 
 * 
 * 
 * In a YorkBinarySearchTree tree extends YorkLinkedBinaryTree 
 * and adopts same  convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to ensure 
 * that you have correct implementation of YorkBinarySearchTree tree. 
 * 
 *
 */
public class YorkBinarySearchTree<E extends Comparable<E>> extends YorkLinkedBinaryTree<E> {

	
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */
	
	/**
	 *  Constructs an empty binary search tree.
	 */
	public YorkBinarySearchTree() {
		// TODO: Your implementation of this method starts here
	}
	
	/**
	 *  Constructs a binary search tree with given element at root 
	 */
	public YorkBinarySearchTree(E e) {
		// TODO: Your implementation of this method starts here

	}
	
	/**
	 * 
	 * @param objects array of element to be added into this tree 
	 */
	
	public YorkBinarySearchTree(E[] objects) {
		// TODO: Your implementation of this method starts here
		
	}
	
	/**
	 * Search of element inside the tree 
	 * if the element is found, then return the position of the element 
	 * if the element  is not found, return null 
	 * @param e  input element 
	 * @return  position of element if element exist inside the tree or null if element not exist
	 */
	
	public Position<E> search(E e) {
		// TODO: Your implementation of this method starts here
		return null;
	}
	
	/**
	 * Remove element e from tree.
	 * if the element is found, remove its position and  return the position of its parent 
	 * if the element  is not found, return null
	 *  
	 * 
	 * @param e the input element for remove  
	 * @return  parent position of the  removed element or null 
	 */
	
	public Position<E> remove (E e){
		// TODO: Your implementation of this method starts here
		return null;
		
	}
	
	
	
	/**
	 * Adds the input  element to the binary search tree in 
	 * the appropriate position.  
	 * Note that equal elements are added to the right.
	 * @param e the element that will be added to binary search tree 
	 * @return the Position of the newly added element 
	 */
	public Position<E> insert(E e) {
		// TODO: Your implementation of this method starts here
		 return null;

	}
	
	/**
	 * Returns true if the tree is a full binary tree
	 * @return  true if the tree is a full binary tree
	 */
	
	public boolean isFullBST() {
		// TODO: Your implementation of this method starts here
		return false;

	}
	
	
	
	/**
	 * Returns the number of leaf nodes  
	 * @return Returns the number of leaf nodes 
	 */
	public int getNumberOfLeaves() {
		// TODO: Your implementation of this method starts here
		return -1;
		
	}
	
	
	/**
	 * Returns the number of non-leaf nodes
	 * @return Returns the number of non-leaf nodes
	 */
	public int getNumberofNonLeaves() {
		// TODO: Your implementation of this method starts here
		return -1;
		
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in inorder.
	 * @return  iterable collection of positions of the tree, reported in inorder
	 */
	public Iterable<Position<E>> inorder() {
		// TODO: Your implementation of this method starts here
		 return null;
	}

	 
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 * 
	 * @return iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		// TODO: Your implementation of this method starts here
		 return null;

	}
	
	
	
	/**
	 * 
	 * Returns an iterable collection of positions of the tree, reported in postorder
	 * 
	 * @return iterable collection of positions of the tree, reported in postorder
	 */
	public Iterable<Position<E>> postorder() {
		// TODO: Your implementation of this method starts here
		 return null;

	}
	

	
	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * @return iterable collection of positions of the tree in breadth-first order
	 */
	public Iterable<Position<E>> breadthfirst() {
		// TODO: Your implementation of this method starts here
		 return null;		

	}
	
	
	
	/**
	 * Overrides positions to make inorder the default order for binary trees.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		 return null;
	}

	
}
