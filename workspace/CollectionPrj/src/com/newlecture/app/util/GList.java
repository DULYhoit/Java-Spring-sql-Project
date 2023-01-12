package com.newlecture.app.util;

public class GList<T> {
	private Object[] nums;
	private int current;
	private int capacity;
	private int amount;
	public GList() {
		nums = new Object[3];
		current = 0;
		capacity = 3;
		amount = 5;
	}

	public void add(T num) {
		
		if(capacity <= current) {
			Object[] temp = new Object[capacity+amount];
			for (int i = 0; i < current; i++) {
				temp[i] = nums[i];
				
				nums = temp;
				capacity+=amount;
			}
				
		}
		
		
		nums[current] = num;
		current++;
		
	}

	public void clear() {
		
			
			current = 0;
		
		
	}

	public T get(int index) {
		if(current <= index) {
			throw new IndexOutOfBoundsException();
		}
		return (T)nums[index];
	}

	public int size() {
		
		return current;
	}

}
