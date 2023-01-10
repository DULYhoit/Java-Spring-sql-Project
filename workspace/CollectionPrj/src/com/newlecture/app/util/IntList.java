package com.newlecture.app.util;

public class IntList {
	private int[] nums;
	private int current;
	public IntList() {
		nums = new int[3];
		current = 0;
	}

	public void add(int num) {
		nums[current] = num;
		current++;
		
	}

	public void clear() {
		
			
			current = 0;
		
		
	}

	public int get(int index) {
		if(current <= index) {
			throw new IndexOutOfBoundsException();
		}
		return nums[index];
	}

	public int size() {
		
		return current;
	}

}
