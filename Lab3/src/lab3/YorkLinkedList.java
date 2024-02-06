package lab3;

import java.util.*;
import java.lang.annotation.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name :		Rayhaan Yaser Mohammed
//Yorku Email :		ray116@my.yorku.ca
//Date :			07/02/2024
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
	@TimeComplexity(value = "")
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
		for (int j = 0; j <= i; j++) {	//TCJ: here we iterate from 0 to i, so our loop will run i+1 times
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
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: "+ i + "out of bounds");
		Node<E> curr = head;
		for (int j = 0; j < i; j++) {	//TCJ: we need to find the node at index i-1
			curr = curr.next;
		}
		E res = curr.next.element;
		curr.next.element = e;
		return res;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException("Index: "+ i + "out of bounds");

		Node<E> tmp = new Node<>(e);

		if ( i == 0){
			tmp.next = head;
			head = tmp;
		} else {
			Node<E> curr = head;
			for  (int j = 0; j < i - 1; j++){ //TCJ: We need to find the node at index i-1
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
	@TimeComplexity(value = "")
	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		return null;

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
	@TimeComplexity(value = "")
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		return null;
		

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return null;

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
		// TODO: Your implementation of this method starts here
		return 99;
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
	@TimeComplexity(value = "")
	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		
		return -99;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	
	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		 return new String();
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return null;
		
	}

	

}
