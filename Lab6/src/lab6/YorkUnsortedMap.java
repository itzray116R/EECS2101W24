package lab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : 	Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 08/03/2024
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
			return key;
			
		}

		@Override
		public V getValue() {
			return value;
			
		}

		/**
		 * Sets the value of this Entry with specified value
		 * 
		 * @param newValue the new value
		 * @return old value of this entry
		 */
		public V setValue(V newValue) {
			V v = this.value;
			this.value = newValue;
			return v;
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
		entries = new ArrayList<>() ;
		this.loadFactor = LOADFACTOR;
		this.capacity = INITCAPACITY;
	}

	/**
	 * One argument constructor Construct a map with the specified initial capacity
	 * and default load factor
	 */
	public YorkUnsortedMap(int capacity) {
		entries = new ArrayList<>(capacity) ;
		this.loadFactor = LOADFACTOR;
		this.capacity = INITCAPACITY;
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
		entries = new ArrayList<>(capacity) ;
		this.loadFactor = loadFactor;
		this.capacity = capacity;
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
	public V get(K key) throws NullPointerException {
		if (key == null) throw new NullPointerException();
		for (MapEntry<K,V> e : entries) {
			if (e.getKey().equals(key)) return e.getValue();
		}
		return null;
	}

	@Override
	public void clear() {
		entries.clear();
	}

	@Override
    public V put(K key, V value) throws NullPointerException {
        if (key == null || value == null)
            throw new NullPointerException();

        if (size >= capacity * loadFactor)
            extendSize();

        for (MapEntry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                remove(key);
                entries.add(new MapEntry<>(key, value));
                return oldValue;
            }
        }

        entries.add(new MapEntry<>(key, value));
        size++;
        return null;
    }

	private void extendSize() {
		List<MapEntry<K,V>> list = new ArrayList<>(2*capacity);
		for  (MapEntry<K,V> entry: entries) {
			list.add(entry);	
		}
		entries = list;
	}

	@Override
	public V remove(K key) throws NullPointerException {
		if  (key == null) throw new NullPointerException();
		for (MapEntry<K,V> entry : entries) {	
			if  (entry.getKey().equals(key)) {
				V v = entry.getValue();
				entries.remove(entry);
				size--;
				return v;
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		if  (key == null) throw new NullPointerException();
		for (MapEntry<K,V> e : entries) {
			if (e.getKey().equals(key)) return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		for  (MapEntry<K,V> e : entries) {
			if (value.equals(e.getValue())) return true;
		}
		return false;
	}

	@Override
	public Iterable<K> keySet() {
		List<K> lizt = new ArrayList<>();
		for  (MapEntry<K,V> e: entries) lizt.add(e.getKey());
		return lizt;
	}

	@Override
	public Iterable<V> values() {
		List<V> lizt = new ArrayList<>();
		for  (MapEntry<K,V> e: entries) lizt.add(e.getValue());
		return lizt;
	}

	@Override
public Iterable<Entry<K, V>> entrySet() {
    return new Iterable<Entry<K, V>>() {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private Iterator<MapEntry<K, V>> mapEntryIterator = entries.iterator();
                @Override
                public boolean hasNext() {
                    return mapEntryIterator.hasNext();
                }
                @Override
                public Entry<K, V> next() {
                    return mapEntryIterator.next();
                }
            };
        }
    };
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
		if (entries.isEmpty()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		Iterator<MapEntry<K, V>> it = entries.iterator();
		while (it.hasNext()) {
			MapEntry<K, V> entry = it.next();
			sb.append(entry.toString());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append(']');
		return sb.toString();
	}
}
