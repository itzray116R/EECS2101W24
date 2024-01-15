package lab2;

import java.util.*;
import java.lang.annotation.*;

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


public class YorkArrayList<E> implements List<E> {

	/**
	 * Initial size, default size, for the Array list
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * 
	 * Stores the elements of the array list Remember that you can not instantiate
	 * an array of E[], but you can instantiate an array of Object and then typecast
	 * it.
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private E[] data = (E[]) new Object[INITSIZE];

	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/**
	 * No argument constructor
	 */
	public YorkArrayList() {
		// TODO: Your implementation of this method starts here
	}
	
	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	public YorkArrayList(E[] objects) {
		// TODO: Your implementation of this method starts here
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

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		 return null;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		 return null;


	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here


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
		// TODO Your implementation of this method starts here
		 return false;

	}
	
	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		 return false;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		 return false;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
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