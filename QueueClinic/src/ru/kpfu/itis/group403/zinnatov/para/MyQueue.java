package ru.kpfu.itis.group403.zinnatov.para;


import java.util.Iterator;

public interface MyQueue<T> {



	boolean offer(T e);
	T peek();
	T poll();
	int size();
	boolean isEmpty();


}
