package lab7;

import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 
import java.util.LinkedList;
import org.w3c.dom.Node;
///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 17/05/2024
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
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
	

		public Node<E> getParent() {
			return parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		} 

		public void setElement(E e) {
			element = e;
		}

		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}

		public void setLeft(Node<E> leftChild) {
			left = leftChild;
		}

		public void setRight(Node<E> rightChild) {
			right = rightChild;
		}

		@Override
		public E getElement() throws IllegalStateException {
			return element;
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
		root = null;
		size = 0;
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		LinkedList<Position<E>> children = new LinkedList<>(); //initialize the list as a Linked List
		children.add(node.getLeft());
		children.add(node.getRight());
		return children;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		int count = 0;
		if (node.getLeft() != null) {
			count++;
		}
		if (node.getRight() != null) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.getLeft() != null || node.getRight() != null;
	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.getLeft() == null && node.getRight() == null;
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.equals(root);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return root == null;
		
	}
	
	/**
	 *  Places element e at the root of an empty tree and returns its new Position.
	 *  
	 * @param e element of root 
	 * @return  position of root 
	 * @throws IllegalStateException if the tree is not empty
	 */
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		} else {
			root = new Node<>(e, null, null, null);
			// size++;
			return root;
		}
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
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		if (node == root) return 0;
		return 1 + depth(node.getParent());
	}

	/**
	 * 
	 * @param p A valid Position within the tree
	 * @return Returns the height of the subtree rooted at Position p.
	 * @throws IllegalArgumentException
	 */
	public int height(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E> ) p;
		int height = 0;
		while (node != root) {
			height++;
			node = node.getLeft() != null ? node.getLeft() : node.getRight();
		}
		return height - 1;
	}

	/**
	 * Return the height of this binary tree
	 * 
	 * @return the height of this binary tree
	 */
	public int height() {
		
		return height(root);
		

	}	

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		return node.getRight();
	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		Node<E> node = (Node<E>) p;
		Node<E> parent = node.getParent();
		return parent.getLeft() == node ? parent.getRight() : parent.getLeft();
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
		Node<E> curr = (Node<E>) p;
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		if (curr.getLeft() != null) {
			throw new IllegalArgumentException("The given position has already a left child");
		} else {
			Node<E> newNode = new Node<>(e, curr, null, null);
			curr.setLeft(newNode);
			return newNode;
		}
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
		Node<E> curr = (Node<E>) p;
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		if (curr.getRight() != null) {
			throw new IllegalArgumentException("The given position has already a right child");
		} else {
			Node<E> newNode = new Node<>(e, curr, null, null);
			curr.setRight(newNode);
			return newNode;
		}
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
		if (p == null || ((Node<E>) p).getParent() == p)  throw new IllegalArgumentException("P is not a valid position!");
		E temp = p.getElement();
		((Node<E>)p).setElement(e);
		return temp;
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
		Node<E> node = (Node<E>) p;
		if (node == null || node.getParent() == node)  throw new IllegalArgumentException("P is not a valid position!");
		if (node.getLeft() != null && node.getRight() != null) throw new IllegalArgumentException("P cannot have 2 children");
		Node<E> parent = node.getParent();
		Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight(); // get the child of the node
		if (child != null) {
			child.setParent(parent);
		}
		if (node == root) {
			root = child;
		} else {
			if (parent.getLeft() == node) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		node.setElement(null);
		node.setParent(node);
		node.setLeft(null);
		node.setRight(null);
		size--;		
		return parent;
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
	public void attach(Position<E> p, YorkLinkedBinaryTree<E> t1, YorkLinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = (Node<E>) p;
		if (node == null || node.getParent() == node)  throw new IllegalArgumentException("P is not a valid position!");
		if (isInternal(node)) throw new IllegalArgumentException("P is not a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}		
	}
	
	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Iterator<Position<E>> positionIterator = positions().iterator();

			@Override
			public boolean hasNext() {
				return positionIterator.hasNext();
			}

			@Override
			public E next() {
				return positionIterator.next().getElement();
			}

			@Override
			public String toString() {
				List<E> elements = new ArrayList<>();
				while (positionIterator.hasNext()) {
					elements.add(positionIterator.next().getElement());
				}
				return elements.toString();
			}
		};
	}

	/**
	 * The YorkLinkedBinaryTree tree is an ordered binary tree that supports the
	 * preorder traversal algorithm to visit tree position or elements.
	 */
	
	@Override
	public Iterable<Position<E>> positions() {
		LinkedList<Position<E>> pos = new LinkedList<>();
		if (root != null) preDFS(root, pos);
		return pos;
	}

	public void preDFS(Node<E> root, LinkedList<Position<E>> pos) {
		if (root == null) {
			return;
		}
		
		pos.add(root);
		preDFS(root.getLeft(), pos);
		preDFS(root.getRight(), pos);
	}
}
