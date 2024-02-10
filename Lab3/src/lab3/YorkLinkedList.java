package lab3;

import java.util.*;
import java.lang.annotation.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name :		Rayhaan Yaser Mohammed
//Yorku Email :		ray116@my.yorku.ca
//Date :			09/02/2024
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
public class YorkLinkedList<E> implements List<E> {

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	///////////////////////////////////////////

	/**
	 * Need to use the variable head to refer to the first node in the list, and the
	 * variable tail to the last node.
	 * 
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> head, tail;
	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/////////////////////////////////////////

	public YorkLinkedList() {
		head = null;
		tail = null;
	}

	public YorkLinkedList(E[] objects) {
		if(objects == null) {
			throw new NullPointerException("Input array is Null");
		}

		head = null;
		tail = null;

		for (E obj : objects){
			addLast(obj);
		}
	}

	@Override
	public int size() {
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		//implementation
		return size == 0;
	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)") 
	//justification = "Adding a new element at the head always takes constant time.")
	public void addFirst(E e) {
		Node<E>  tmp = new Node<>(e); //create a new node

		if(isEmpty()){
			head = tmp;
			tail = tmp;
		} else {
			tmp.next = head;
			head = tmp;
		}
		size++;
	}

	/**
	 * return the element stored inside the first node of this list the method
	 * return null if this list is empty
	 * 
	 * @return
	 */
	public E getFirst() {
		if(isEmpty()) return null; // if list empty return null
		return head.element; // return head
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)")
	public void addLast(E e) {
		Node<E>  tmp = new Node<>(e); //create a new node

		if(isEmpty()){
			head = tmp;
			tail = tmp;
		} else {
			tail.next = tmp;
			tail= tmp;
		}
		size++;
	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		if(isEmpty()) return null; // is list is empty return null
		return tail.element; // return the tail
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: "+ i + "out of bounds");

		Node<E> curr = head;
		for (int j = 0; j < i; j++) {	//TCJ: here we iterate from 0 to i, so our loop will run i+1 times
			curr = curr.next;
		}
		return curr.element;	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i + " out of bounds");
		Node<E> curr = head;
		for (int j = 0; j < i; j++) { //TCJ: we need to find the node at index i-1
			curr = curr.next;
		}
		E res = curr.element;
		curr.element = e;
		return res;
	}
	

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
	//	if (i < 0 || i > size) throw new IndexOutOfBoundsException("Index: " + i + " out of bounds"+size);
	
		Node<E> tmp = new Node<>(e);
	
		if (i == 0) {
			tmp.next = head;
			head = tmp;
			if (size == 0) {
				tail = tmp;
			}
		} else if (i > size) {
			tail.next = tmp;
			tail = tmp;
		} else {
			Node<E> curr = head;
			for (int j = 0; j < i - 1; j++) {
				curr = curr.next;
			}
			tmp.next = curr.next;
			curr.next = tmp;
		}
		size++;
	}
	

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(1)")
	/*
	 * TCJ : 
	 */
	public E removeFirst() {
		if(isEmpty()) return null;

		E rmdElement = head.element;
		head = head.next;
		size--;

		if(isEmpty()) tail = null;

		return rmdElement;

	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	public E removeLast() {
		if(isEmpty()) return null;

		if(size == 1) {
			E rmdElement = head.element;
			head = tail = null;
			size = 0;
			return rmdElement;
		}
		Node<E> curr = head;
		Node<E> prev = null;

		while ( curr.next != null) {
			prev = curr;
			curr =  curr.next;
		}
		E rmdElement = curr.element;
		prev.next = null;
		tail = prev;
		size--;
		
		return rmdElement;
		

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		//TCJ: The time complexity of removing an element from a linked list is O(n), where n is the number of elements in the LinkedList. This is because we need to
		//TCJ: The index of element to be removed is out of bounds, throw an exception
		if(i < 0 || i >= size) throw new IndexOutOfBoundsException("index " + i + " is out of bound");
		
		Node<E> curr = head;
		for (int j = 0; j < i; j++) curr = curr.next;

		E rmdElement = curr.next.element;
		curr.next = curr.next.next;
		size--;
		return rmdElement;
	}

	/**
	 * 
	 * Search this list and return the first match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the lowest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(E e) {
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(e, curr.element)) return i;
			curr = curr.next;
		}
		return -1;
	}
	

	/**
	 * Search this list and return the last match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the largest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	// TCJ: Taking Time Complexity of O(n) as we are iterating through
	//	 all elements in the LinkedList to find the last occurrence of the given element.
	public int lastIndexOf(E e) {
		int res = -1;
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(e, curr.element)) res = i;
			curr = curr.next;
		}
		return res;
	}
	

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean contains(E e) throws NullPointerException {
		if(e == null) throw new NullPointerException("The element is null");
		if(isEmpty()) return false;
		Node<E> curr = this.head;
		while(curr != null){
			if(e.equals(curr.element)) return true;
			curr = curr.next;
		}
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		if (e == null)  throw new NullPointerException("The element is null.");
		if(head == null) return false;
		if(head.element.equals(e)){
			head = head.next;
			size--;
			if(size == 0) tail = null; // if list becomes empty after removal of head node	
			return true;
		}
		Node<E> curr = head;
		while(curr.next != null & !curr.next.element.equals(e)){
			curr = curr.next;
		}
		if(curr.next != null){
			curr.next = curr.next.next;
			size--;
			if(curr.next == null) tail = curr; // if last remaining node in the list is removed, update the tail reference
			return true;
		}
		return false;	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		if(otherList == null) throw new NullPointerException("Cannot add elements from a null list.");
		boolean res = false;
		for (E  element : otherList) { 
			addLast(element);
			res = true;
		}
		return res;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		if(otherList == null) throw new NullPointerException("Cannot add elements from a null list.");

		boolean moded = false;
		for (E element: otherList) {
			moded |= remove(element);
		}
		return moded;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		if(otherList == null) throw new NullPointerException("Cannot add elements from a null list.");

		boolean moded = false;

		Iterator<E>  itr = iterator();
		while(itr.hasNext()) {
			E currElement = itr.next();
			if (!otherList.contains(currElement)) {
				itr.remove();
				moded = true;
			}
		}
		return moded;
	}

	
	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;

		while (current != null) {
			result.append(current.element);
			if (current.next != null) {
				result.append(", ");
			}
			current = current.next;
		}

		result.append("]");
		return result.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				E element = current.element;
				current = current.next;
				return element;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	

}
