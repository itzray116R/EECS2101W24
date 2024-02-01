package lab2;

import java.util.*;
import java.lang.annotation.*;

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
		//alredy implementated
	}
	
	/**
	 * Constructor takes array of elements and then add them to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	public YorkArrayList(E[] objects) {
		if (objects == null) {
			throw new IllegalArgumentException("Input array cannot be null");
		}
	
		size = objects.length;
		data = (E[]) new Object[size];
	
		// Copy elements from objects to data
		for (int i = 0; i < size; i++) {
			data[i] = objects[i];
		}
	}


	@Override
	public int size() {
		return this.size;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size()){
			throw new IndexOutOfBoundsException("Index out of bounds: " + i);
		}
		return this.data[i];
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i >= 0 && i < size) {
			E oldValue = data[i];
			data[i] = e;
			return oldValue;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds: " + i);
		}
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
        if (size == data.length) {
            E[] tmp = (E[]) new Object[2 * size];
            for (int j = 0; j < size; j++) {
                tmp[j] = data[j];
            }
            data = tmp;
        }
        if (i >= 0 && i <= size) {
            for (int j = size; j > i; j--) {
                data[j] = data[j - 1];
            }
            data[i] = e;
            size++;
        } else if (i == size) {
			// If i equals size, it means appending to the end
			data[size++] = e;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds: " + i);
		}
    }

	/**
	 * Method to remove an element from list at specific position
	 * @param i - Position where we want to delete the element
	 * @throws IndexOutOfBoundsException if provided index is less than zero or greater than the size of the ArrayList
	 * @throws IndexOutOfBoundsException if provided index is less than zero or greater than the size of the list
	 * @throws IndexOutOfBoundsException if the index is not valid for the current list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i< 0 || i >= size){
			throw new IndexOutOfBoundsException("Index out of bounds: " + i);
		}
		E tmp = data[i];
		for (int j=i ;j < size -1; j++) {
			data[j]= data[j+1];
		}
		size--;
		return tmp;
	}




	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean contains(E e) throws NullPointerException {
		if (e == null){
			throw new NullPointerException("Array cannot be null");
		}
		for (int i=0; i < size; i++){
			if (data[i].equals(e))
				return true;
		}
		return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean remove(E e) throws NullPointerException {
		if(e == null) throw new NullPointerException("e cannot be null" + e);
		int i = -1;
		for  (int j = 0; j < size; j ++ ) {
			if (data[j].equals(e)){
				i = j;
			}
		}
		if(i == -1)
			return false;
		for  (int k = i ; k < size-1; k++ ){
			data [k] = data [k+1];
		}
		size--;
		return true;
	}
	
	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		for (E value : otherList){
			add(size,value);
		}
		return true;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		for (E value : otherList){
			remove(value);
		}
		return true;

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		for (int i = 0; i < size; i++) {
            if (!otherList.contains(get(i))) {
                remove(i);
                i--;
            }
        }
        return true;
	}
	
	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i < size - 1)
                result += ", ";
        }
        result += "]";
        return result;
	}
	
	@Override
	public Iterator<E> iterator() {
		final int[] index = {0};
		return  new Iterator<E>() {
			@Override
			public  boolean hasNext() {
				return index[0] < size;
			}
			@Override
			public E next() {
				E value = data[index[0]];
				index[0]++;
				return value;
			}
		};
	}
	
}