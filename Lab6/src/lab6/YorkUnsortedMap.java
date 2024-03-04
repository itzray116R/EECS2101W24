package lab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

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


public class YorkUnsortedMap<K, V> implements Map<K, V> {

	
	
	// -------------- nested MapEntry Class ------------------
	private static class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		/**
		 * Constructor to set the key and value of this entry
		 * 
		 * @param key   the key
		 * @param value the value
		 */
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO: Your implementation of this method starts here
			return null;
			
		}

		@Override
		public V getValue() {
			// TODO: Your implementation of this method starts here
			return null;
			
		}

		/**
		 * Sets the value of this Entry with specified value
		 * 
		 * @param newValue the new value
		 * @return old value of this entry
		 */
		public V setValue(V newValue) {
			// TODO: Your implementation of this method starts here
			return null;
		}

		/**
		 * String representation for map entry
		 */
		@Override
		public String toString() {
			return "<" + key + ", " + value + ">";
		}

	}

	// ---- end of nested MapEntry class----------------------
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define default load factor
	private static final double LOADFACTOR = 0.5;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the default hash-table size. Must be a power of 2
	private static final int INITCAPACITY = 4;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the maximum hash-table size. 1 << 30 is same as 2^30
	private static final int MAXCAPACITY = 1 << 30;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The current hash-table capacity. Capacity must be a power of 2
	private int capacity;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// User specify a load factor used in this hash table
	private double loadFactor;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The number of entries in the map
	private int size = 0;

	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkUnsortedMap You can use java.util.ArrayList or java.util.LinkedList
	 * (DoublyLinked) List to implement and store the map entries
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private List<MapEntry<K, V>> entries;

	/**
	 * no argument constructor Construct a map with the default capacity and load
	 * factor
	 */
	public YorkUnsortedMap() {
		// TODO: Your implementation of this method starts here
		
	}

	/**
	 * One argument constructor Construct a map with the specified initial capacity
	 * and default load factor
	 */
	public YorkUnsortedMap(int capacity) {
		// TODO: Your implementation of this method starts here
	}

	/**
	 * Construct a map with the specified initial capacity and load factor. Note:
	 * the capacity of map must be power of 2 User/client can specify any value as
	 * map capacity. You should make sure that the map is created with the power of
	 * 2 capacity that is greater than the user's given capacity. For example, if
	 * the user specifies the input capacity as 13, you should create a map with a
	 * capacity of 16.
	 * 
	 * @param capacity   map capacity specified by client
	 * @param loadFactor map loading factor
	 */
	public YorkUnsortedMap(int capacity, double loadFactor) {
		// TODO: Your implementation of this method starts here
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return -999;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return false;
		
	}

	@Override
	public V get(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return null;
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here

	}

	@Override
	public V put(K key, V value) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return null;

	}

	@Override
	public V remove(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return null;
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		return false;


	}

	@Override
	public boolean containsValue(V value) {
		// TODO: Your implementation of this method starts here
		return false;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO: Your implementation of this method starts here
		return null;

	}

	@Override
	public Iterable<V> values() {
		// TODO: Your implementation of this method starts here
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO: Your implementation of this method starts here
		return null;
	}

	/**
	 * Return String value represent the content of map 
	 *  if Map contains only two entries 
	 *  put("A1", 124); and put("A2", 125);
	 *  the output will be 
	 *   "[<A1, 124>,<A2, 125>]"
	 */
	@Override
	public String toString() {

		// TODO: Your implementation of this method starts here
		 return new String();

	}

}
