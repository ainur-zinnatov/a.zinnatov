package ru.kpfu.itis.group403.zinnatov.MyArrayList;

import java.util.*;

/**
 * Created by hp on 14.03.2015.
 */
public  class DynamicList<T> implements List<T> {
	private static final Object[] EMPTY_ELEMENTDATA = {};

	private int size;
	private Object[] elementData;
	public DynamicList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					initialCapacity);
		}
	}
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		 return indexOf(o) >= 0;
	}



	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int iter;
			@Override
			public boolean hasNext() {
				return iter!=size;
			}

			@Override
			public T next() {
				if (iter == size){
					throw new NoSuchElementException();
				}
				return (T)elementData[iter++];

			}
		};
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public String toString() {
		return "DynamicList{" +
				"size=" + size +
				", elementData=" + Arrays.toString(elementData) +
				'}';
	}



	@Override
	public boolean add(T t) {
		size++;
		elementData = Arrays.copyOf(elementData, size);
		elementData[size-1]=t;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if(o.equals(elementData[i])){
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Object[] a = c.toArray();
		int numNew = a.length;
		System.arraycopy(a, 0, elementData, size, numNew);
		size += numNew;
		return numNew != 0;
	}


	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		Object[] a = c.toArray();
		int numNew = a.length;

		int numMoved = size - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew,
					numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		size += numNew;
		return numNew != 0;	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		elementData = new Object[0];
	}

	@Override
	public T get(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException();
		return (T) elementData[index];
	}

	@Override
	public T set(int index, T element) {
		if (index >= size)
			throw new IndexOutOfBoundsException();
		T oldValue = (T) elementData[index];
		elementData[index] = element;
		return oldValue;
	}

	@Override
	public void add(int index, T element) {
		elementData = Arrays.copyOf(elementData, size+1);

		System.arraycopy(elementData, index, elementData, index + 1,
				size - index);
		elementData[index] = element;
		size++;
	}

	@Override
	public T remove(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException();

		T oldValue = (T) elementData[index];

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index+1, elementData, index,
					numMoved);
		elementData[--size] = null; // clear to let GC do its work

		return oldValue;
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i]==null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size-1; i >= 0; i--)
				if (elementData[i]==null)
					return i;
		} else {
			for (int i = size-1; i >= 0; i--)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		return listIterator(0);
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return new ListIterator<T>() {
			private int cursor = index;
			private int lastRet = index-1;

			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public T next() {
				if (cursor == size){
					throw new NoSuchElementException("не существует элемента с индексом " + cursor );
				}
				int i = cursor;
				cursor = i+1;
				return (T)elementData[lastRet = i];
			}
			public boolean hasPrevious() {
				return cursor != 0;
			}

			public int nextIndex() {
				return cursor;
			}

			public int previousIndex() {
				return cursor - 1;
			}

			@Override
			public void remove() {
				if (lastRet < 0)
					throw new IllegalStateException();


				try {
					DynamicList.this.remove(lastRet);
					cursor = lastRet;
					lastRet = -1;

				} catch (IndexOutOfBoundsException ex) {
					throw new ConcurrentModificationException();
				}
			}

			@SuppressWarnings("unchecked")
			public T previous() {

				int i = cursor - 1;
				if (i < 0)
					throw new NoSuchElementException();
				Object[] elementData = DynamicList.this.elementData;
				if (i >= elementData.length)
					throw new ConcurrentModificationException();
				cursor = i;
				return (T) elementData[lastRet = i];
			}

			public void set(T e) {
				if (lastRet < 0)
					throw new IllegalStateException();


				try {
					DynamicList.this.set(lastRet, e);
				} catch (IndexOutOfBoundsException ex) {
					throw new ConcurrentModificationException();
				}
			}

			public void add(T e) {


				try {
					int i = cursor;
					DynamicList.this.add(i, e);
					cursor = i + 1;
					lastRet = -1;

				} catch (IndexOutOfBoundsException ex) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex > size)
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex +
					") > toIndex(" + toIndex + ")");
		Object [] obj = Arrays.copyOfRange(elementData,fromIndex,toIndex);
		List<T> list;
		if (fromIndex == toIndex){
			list = Collections.EMPTY_LIST;
		}else {
			list = Arrays.asList((T)obj);
		}
		return list;


	}
}
