package ru.kpfu.itis.group403.zinnatov.para;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by hp on 21.03.2015.
 */
public class MyQueueClass<T> implements MyQueue {

	private Object[] queue;
	private  int endPosition = -1;
	private int startPosition =-1;

	public MyQueueClass(int size) {
		this.queue = new Object[size];
	}



	public boolean offer(Object t) {

		if (startPosition < 0) {
			startPosition = 0;
			endPosition = 1;
		} else if ((endPosition + 1) % queue.length == startPosition) {
			throw new IndexOutOfBoundsException();

		}
		endPosition = (endPosition + 1) % queue.length;
		queue[endPosition++] = t;
		return true;
	}
	@Override
	public String toString() {
		return "MyQueueClass{" +
				"queue=" + Arrays.toString(queue) +
				'}';
	}

	@Override
	public T peek() {
		if (isEmpty()){
			return null;
		}
		return (T)queue[startPosition];
	}

	@Override
	public T poll(){
		if (isEmpty()){
			return null;
		}
		startPosition = (startPosition)%queue.length;
		return (T)queue[startPosition];
	}

	@Override
	public int size() {
		return endPosition-startPosition;
	}

	@Override
	public boolean isEmpty() {
		return queue.length == 0 ;
	}





}
