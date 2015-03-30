package ru.kpfu.itis.group403.zinnatov.stack;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by hp on 17.03.2015.
 */
public class LinkedStack<T> implements MyStack<T> {
	private int size = 0;
	private Item elementData;
	@Override
	public T pop() {
		if(size <= 0){
			throw new NoSuchElementException();
		}
		T object = elementData.getT();
		elementData = elementData.getNextItem();
		size--;
		return object;
	}


	@Override
	public T push(T t) {
		Item firstItem = new Item(t);
		firstItem.setNextItem(elementData);
		elementData = firstItem;
		size++;
		return t;
	}


	@Override
	public T peek() {
		int     len = size();

		if (len == 0)
			throw new EmptyStackException();
		return elementData.getT();
	}


	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	private class Item{
		private T object;
		private Item nextItem = null;

		public Item(T t){
			this.object = t;
		}
		public Item getNextItem(){
			return nextItem;
		}
		public void setNextItem(Item nextItem){
			this.nextItem = nextItem;
		}
		public T getT() {
			return object;
		}
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			private int c = 0;
			private int count = 0;
			@Override
			public boolean hasNext() {
				return c < size;
			}

			@Override
			public Object next() {
				if(c == size){
					throw new NoSuchElementException();
				}
				Item current;
				for(current = elementData,c = 0;c++ < count; current = current.getNextItem());
				count++;
				return current.getT();
			}
		};
	}

	@Override
	public void forEach(Consumer action) {

	}


}
