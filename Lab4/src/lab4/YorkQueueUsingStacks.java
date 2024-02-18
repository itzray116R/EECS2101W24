package lab4;

import java.util.*;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : February 13, 2024
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
 * Implement the queue interface using two stacks 
 * 
 * @param <E>
 */

public class YorkQueueUsingStacks<E> implements Queue<E> {
	
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private Stack<E> stack1;
	private Stack<E> stack2;	

	public YorkQueueUsingStacks(){
		this.stack1 = new YorkArrayStack<>();
		this.stack2 = new YorkArrayStack<>();
	}
	
	
	@Override
	public int size() {
		return  stack1.size() + stack2.size();
	
	}

	@Override
	public boolean isEmpty() {
		return  stack1.isEmpty() && stack2.isEmpty();
		
	}

	@Override
	public void clear() {
		stack1.clear();
		stack2.clear();
	}

	@Override
	public void enqueue(E e) {
		stack1.push(e);
	}
		

	@Override
    public E first() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.top(); // Return the front tmp without removing it
    }

	@Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Queue is Empty");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); // Remove and return the front tmp
    }

	@Override
	public boolean contains(E e) throws NullPointerException {
		// Check if the tmp is present in stack2
		Stack<E> tempStack = new YorkArrayStack<>();
		while (!stack2.isEmpty()) {
			E tmp = stack2.pop();
			tempStack.push(tmp);
			if (Objects.equals(e, tmp)) {

				while (!tempStack.isEmpty()) {
					stack2.push(tempStack.pop());
				}
				return true;
			}
		}

		while (!tempStack.isEmpty()) {
			stack2.push(tempStack.pop());
		}

		while (!stack1.isEmpty()) {
			E tmp = stack1.pop();
			tempStack.push(tmp);
			if (Objects.equals(e, tmp)) {

				while (!tempStack.isEmpty()) {
					stack1.push(tempStack.pop());
				}
				return true;
			}
		}

		while (!tempStack.isEmpty()) {
			stack1.push(tempStack.pop());
		}

		return false;
	}

	
	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted tmp should be the last tmp
	 * 
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("[");
		YorkArrayStack<E> tempStack = new YorkArrayStack<>();

		while (!stack2.isEmpty()) {
			tempStack.push(stack2.pop());
		}

		sb.append(tempStack.toString().substring(1, tempStack.toString().length() - 1));

		while (!tempStack.isEmpty()) {
			stack2.push(tempStack.pop());
		}

		if (!stack1.isEmpty()) {
			if (!stack2.isEmpty()) {
				sb.append(", ");
			}
			sb.append(stack1.toString().substring(1, stack1.toString().length() - 1));
		}

		sb.append("]");

		return sb.toString();
	}
}
