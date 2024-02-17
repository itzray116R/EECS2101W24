package lab4;

import java.util.EmptyStackException;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 15/02/2024
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
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayStack<E> implements Stack<E> {

	/**
	 * Initial size, default size, for the Array of stack 
	 * remember that an empty stack has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private E[] stack;
	private int top;
	private int capacity;	

	/**
	 * No argument constructor
	 */
	@SuppressWarnings("unchecked")
	public YorkArrayStack() {
		this.capacity = INITSIZE;
		this.stack = (E[]) new Object[capacity];
		this.top = -1;	
	}

	@SuppressWarnings("unchecked")
	public YorkArrayStack(int capacity) {
		this.capacity = capacity;
		stack = (E[])new Object[capacity];
		this.top = -1;
	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	@SuppressWarnings("unchecked")
	public YorkArrayStack(E[] objects) {
        this.capacity = objects.length;
        this.stack = (E[]) new Object[this.capacity];
        for (E obj : objects) {
            push(obj);
        }
    }

	@Override
	public int size() {
		return this.top +1;
	}

	@Override
	public void clear() {
		for (int i=0;i<=top;i++) {
			stack[i] = null;
		}
		top= -1;
	}
	
	
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(stack[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }
	

	@Override
	public void push(E e) {
    	if (top == capacity - 1) {
    	    capacity *= 2;
   	    	stack = java.util.Arrays.copyOf(stack, capacity);
    	}
    	top++;
    	stack = java.util.Arrays.copyOf(stack, capacity); // deep copy
    	stack[top] = e;
	}	
	
	


	@Override
	public E pop() {
		if  (isEmpty()) throw new EmptyStackException();
		E element = stack[top];
		stack[top--] = null;
		return element;
		

	}
}
