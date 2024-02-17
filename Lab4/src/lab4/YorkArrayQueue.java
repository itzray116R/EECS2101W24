package lab4;

import java.util.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 17/02/2024  
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
 * Queue using expandable circular Array of generic type E. This is called a
 * "circular" queue with expandable array. if the queue (array) is full, create
 * a new queue (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayQueue<E> implements Queue<E> {

	/**
	 * Initial size, default size, for the queue
	 * remember that an empty queue has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */

	private  E[] arr; /* The array used to store the elements in the stack */

	private int front;
	private int size;

	
	
	
	/**
	 * No argument constructor
	 */
	public YorkArrayQueue() {
		this(INITSIZE); // call another constructor		
	}

	@SuppressWarnings("unchecked")
	public YorkArrayQueue(int capacity) {
		arr = (E[]) new Object[capacity];	
		front = 0;
		size = 0;	
	}

	/**
	 * Constructor takes array of elements and then add then to the end of the Array
	 * list
	 * 
	 * @param objects
	 */

	public YorkArrayQueue(E[] objects) {
		this(objects.length);
		for (E obj : objects) enqueue(obj);
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
	@SuppressWarnings("unchecked")
	public void clear() {		
		arr = (E[])new Object[arr.length];
		front = 0;
		size = 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void enqueue(E e) {
		if (e == null)  throw new NullPointerException();
		if(size == arr.length) {
			E[] newArr = (E[]) (new Object[arr.length * 2]);
        	for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        	}
        arr = newArr;
        front = 0;
		}
		arr[(front + size) % arr.length] = e;
		size++;
	}

	@Override
	public E first() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		return arr[front];
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		E tmp = arr[front];
		arr[front] = null;
		front = (front + 1) % arr.length;
		size--;
		return tmp;
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		if (e  == null) throw new NullPointerException();
		for (int i =0 ; i < size; i++) if (arr[(front+i)%arr.length].equals(e)) return true;
		return false;	
	}

	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for  (int i=0; i<size; i++){
			str.append(arr[(front+i)%arr.length]);
			if (i != size-1){
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();
	}
}
