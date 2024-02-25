package lab5;

import java.util.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 25 February 2024
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
 * 
 * You need to complete the implementation of a YorkSortedDoublyLinkedList class
 * The YorkSortedDeoublyLinkedList uses sentinel nodes, header and trailer.
 * Therefore, you need to keep in mind that the first element of a nonempty list
 * is stored in the node just after the header (not in the header itself), and
 * similarly that the last element is stored in the node just before the
 * trailer.
 * 
 * @param <E>
 */
public class YorkSortedDoublyLinkedList<E> implements List<E> {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element) {
			this.element = element;
		}
	}

	/////////////////////////////////////
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list
	//////////////////////////////////
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkSortedDoublyLinkedList 
	 */
	
	

	public YorkSortedDoublyLinkedList() {
		header = new Node<>(null);
		trailer = new Node<>(null);
		header.next = trailer;
		trailer.prev = header;
		size =0;
	}

	/**
	 * 
	 * Take the elements from the input array one by one and then insert them into
	 * the list. you should insert the elements at the end of the list
	 */
	public YorkSortedDoublyLinkedList(E[] objects) {
		this();
		for (int i=0;i <objects.length ;i++) {
			addLast(objects[i]);
		}
	}

	/**
	 * Returns (but does not remove) the first element stored in the first node of
	 * the list. if the list is empty return null otherwise return the first element
	 * stored inside the first node of the list
	 * 
	 * @return
	 */
	public E getFirst() {
		if(isEmpty()) return null;
		return header.next.element;
	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		add(0,e);
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * 
	 * 
	 * @param e
	 */

	public void addLast(E e) {
		add(size, e);
	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		if (size == 0) return null;
		else return trailer.element;
	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * 
	 * @return
	 */

	public E removeFirst() {
		if  (size == 0) return null;
		return remove(0);
	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * 
	 * @return
	 */
	public E removeLast() {
		if (size==0) return null;
		return remove(size -1);
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
		Node<E> curr = header.next;
		int index=0;
		while(curr!=trailer){
			if(curr.element.equals(e)){
				return index;
			}
			curr=curr.next;
			index++;
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
	 * @param e
	 * @return
	 */

	public int lastIndexOf(E e) {
		Node<E> curr = trailer.prev;
		int index=size -1;
		while(curr!=header){
			if(curr.element.equals(e)){
				return index;
			}
			curr=curr.prev;
			index--;
		}
		return -1;
	}

	/**
	 * Sorts a list in ascending order by using a Comparator object
	 * 
	 * @param comparator
	 */
	public void sortAscending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here


	}

	/**
	 * 
	 * Sorts a list in descending order by using a Comparator object
	 * 
	 * 
	 * @param comparator
	 */
	public void sortDescending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here
					
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if  (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index out of bounds" + i);
		Node<E> curr = header.next;
		for  (int j=0;j<i;j++){
			curr = curr.next;
		}
		return curr.element;
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if  (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index out of bounds " + i);
		Node<E> curr = header.next;
		for  (int j=0;j<i;j++)
			curr = curr.next;
		E oldData = curr.element;
		curr.element = e;
		return oldData;
	}

	@Override
	public void add(int i, E e) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException("Index out of Bounds: "  + i);
		Node<E> newNode = new Node<>(e);
		Node<E> curr = header;
		for (int j =0 ; j <i; j++) curr = curr.next;
		newNode.next = curr.next;
		newNode.prev  = curr;
		curr.next.prev = newNode;
		curr.next = newNode;
		size++;
	}

	/**
	 * 
	 * Inserts the new element e after the specified index i in this list. Shifts
	 * the elements after the index i (if any)
	 * 
	 * Remember that You need if the index i is greater than the list size then you
	 * need to add the element e at the end of the list
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */

	public void addAfter(int i, E e) {
		
	}

	/**
	 * Removes all elements between the given lowerindex and upperindex inclusive.
	 * shifting all subsequent elements in the list closer to the front. Index: 0 1
	 * 2 3 4 5 6 Example: if list contains [ 1, 2, 3, 5, 6, 7, 8] you call
	 * removeBetween(2,4) then list will contains [1, 2, 7, 8] Hence, three elements
	 * are removed
	 * 
	 * Note: if the lower or upper index is greater than the size of the list then 
	 * the lower or upper index will be updated to be the end of the list
	 * 
	 * 
	 * 
	 * 
	 * @param lowerindex the lower index
	 * @param upperindex the upper index,
	 * @throws IndexOutOfBoundsException if the index is negative or lowerindex is
	 *                                   greater than upperindex
	 * 
	 */

	public void removeBetween(int lowerindex, int upperindex) {
		// TODO: Your implementation of this method starts here
					


	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		return null;



	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;


	}

	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;


	}

	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;


	}

	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;
	}

	/**
	 * Return String value represent the content of list as example "[30, 110, -110,
	 * -2, 1322]"
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
