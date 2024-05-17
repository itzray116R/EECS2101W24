package lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

import org.w3c.dom.Node;

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
* 1. No System.out.println statements should appear here. Instead, you need to`
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
	private Node<E> BSTRoot;
	private int BSTsize;
	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */
	
	/**
	 *  Constructs an empty binary search tree.
	 */
	public YorkBinarySearchTree() {
		BSTRoot = null;
		BSTsize = 0;
	}
	
	/**
	 *  Constructs a binary search tree with given element at root 
	 */
	public YorkBinarySearchTree(E e) {
		BSTRoot = new Node<E>(e, null, null, null);
		BSTsize = 1;
	}
	
	/**
	 * 
	 * @param objects array of element to be added into this tree 
	 */
	
	public YorkBinarySearchTree(E[] objects) {
		for (E e : objects) {
			insert(e);
		}
	}
	
	/**
	 * Search of element inside the tree 
	 * if the element is found, then return the position of the element 
	 * if the element  is not found, return null 
	 * @param e  input element 
	 * @return  position of element if element exist inside the tree or null if element not exist
	 */
	
	public Position<E> search(E e) {
		return dfs(BSTRoot,e)
	}

	private Position<E> dfs(Node<E> root, E e){
		if (root == null) return null;
		if (root.getElement().equals(e)) return root;
		Position<E> left = dfs(root.getLeft(), e);
		if (left != null) return left;
		Position<E> right = dfs(root.getRight(), e);
		if (right != null) return right;	
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
		Node<E> node = remHelp(BSTRoot,e);
		if (node != null) BSTsize--;
		return node;
	}

	private Node<E> remHelp(Node<E> node ,E e){
		if ( node == null ) return null;
		if (e.compareTo(node.getElement()) > 0) {
			node.setRight(remHelp(node.getRight(), e));
		} else if (e.compareTo(node.getElement()) < 0) {
			node.setLeft(remHelp(node.getLeft(), e));
		} else {
			if (node.getLeft() == null) return node.getRight();
			else if (node.getRight() == null) return node.getLeft();

			Node<E> temp = node;
			while (temp.getLeft() != null) {
				temp = temp.getLeft();
			}

			node.setElement(temp.getElement());
			node.setRight(remHelp(node.getRight(), node.getElement()));
		}

		return node;
	}
	
	
	
	/**
	 * Adds the input  element to the binary search tree in 
	 * the appropriate position.  
	 * Note that equal elements are added to the right.
	 * @param e the element that will be added to binary search tree 
	 * @return the Position of the newly added element 
	 */
	public Position<E> insert(E e) {
		if (BSTRoot == null) {
			BSTRoot = new Node<E>(e, null, null, null);
			BSTsize++;
			return BSTRoot;
		}
		BSTsize++;
		return insertHelper(e, BSTRoot);
	}

	private Node<E> insertHelper(E e, Node<E> node){
		if (node == null) {
			return new Node<>(e, null, null, null);
		}

		if (e.compareTo(node.getElement()) < 0) {
			node.setLeft(insertHelper(e, node.getLeft()));
			node.getLeft().setParent(node);
		} else if (e.compareTo(node.getElement()) >= 0) {
			node.setRight(insertHelper(e, node.getRight()));
			node.getRight().setParent(node);
		}

		return node;
	}
	
	/**
	 * Returns true if the tree is a full binary tree
	 * @return  true if the tree is a full binary tree
	 */
	
	public boolean isFullBST() {
		
		return fullHelper(BSTRoot, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	private boolean fullHelper(Node<E> root, Integer left, Integer right){
		if(root == null) return true;
		if (root.getElement().compareTo((E) left) <= 0 || root.getElement().compareTo((E) right) >= 0) {
			return false;
		}
		return fullHelper(root.getLeft(), left, (Integer) root.getElement()) && fullHelper(root.getRight(), (Integer) root.getElement(), right);
	}
	
	
	/**
	 * Returns the number of leaf nodes  
	 * @return Returns the number of leaf nodes 
	 */
	public int getNumberOfLeaves() {
		return numLeaHelper(BSTRoot);
	}

	private int numLeaHelper(Node<E> node){
		if (node == null) return 0;
		if (node.getLeft() == null && node.getRight() == null) return 1;
		return numLeaHelper(node.getLeft()) + numLeaHelper(node.getRight());
	}
	
	
	/**
	 * Returns the number of non-leaf nodes
	 * @return Returns the number of non-leaf nodes
	 */
	public int getNumberofNonLeaves() {
		return nonNumLeaHelper(BSTRoot);
	}

	private int nonNumLeaHelper(Node<E> node){
		if (node == null || node.getLeft() != null || node.getRight() != null) return 0;
		return 1 + nonNumLeaHelper(node.getLeft()) + nonNumLeaHelper(node.getRight());
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in inorder.
	 * @return  iterable collection of positions of the tree, reported in inorder
	 */
	public Iterable<Position<E>> inorder() {
		LinkedList<Position<E>> pos = new LinkedList<>();
		inorderDFS(pos, BSTRoot);
		return pos;
	}
	
	private void inorderDFS(LinkedList<Position<E>> pos, Node<E> node){
		if (node == null) return;
		inorderDFS(pos, node.getLeft());
		pos.add(node);
		inorderDFS(pos, node.getRight());
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 * 
	 * @return iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		LinkedList<Position<E>> pos = new LinkedList<>();
		preorderDFS(pos, BSTRoot);
		return pos;
	}

	private void preorderDFS(LinkedList<Position<E>> pos, Node<E> node){
		if (node == null) return;
		pos.add(node);
		preorderDFS(pos, node.getLeft());
		preorderDFS(pos, node.getRight());
	}
	
	
	
	/**
	 * 
	 * Returns an iterable collection of positions of the tree, reported in postorder
	 * 
	 * @return iterable collection of positions of the tree, reported in postorder
	 */
	public Iterable<Position<E>> postorder() {
		LinkedList<Position<E>> pos = new LinkedList<>();
		postorderDFS(pos, BSTRoot);
		return pos;
	}

	private void postorderDFS (LinkedList<Position<E>> pos, Node<E> node){
		if (node == null) return;
		postorderDFS(pos, node.getLeft());
		postorderDFS(pos, node.getRight());
		pos.add(node);
	}
	

	
	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * @return iterable collection of positions of the tree in breadth-first order
	 */
	public Iterable<Position<E>> breadthfirst() {
		Queue<Position<E>> q = new LinkedList<>();
		LinkedList<Position<E>> pos = new LinkedList<>();
		q.add(BSTRoot);
		while (!q.isEmpty()) {
			int i = q.size();
			for (int j = 0; j < i; j++) {
				Node<E> tmp = (Node<E>) q.remove();
				if(tmp != null) {
					pos.add(tmp);
					q.add(tmp.getLeft());
					q.add(tmp.getRight());
				}
			}
		}
		return pos;
	}
	
	
	
	/**
	 * Overrides positions to make inorder the default order for binary trees.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		LinkedList<Position<E>> pos = new LinkedList<>();
		inorderDFS(pos, BSTRoot);
		return pos;
	}	
}
