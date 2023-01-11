package com.newlecture.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {
	//List : 매개변수가 식별자로써작동 (중복o)
	//Set : 매개변수로 들어가는 값이곧 식별자(중복X)
	public static void main(String[] args) {
//		GList<Integer> list = new GList<>();
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		try {
			list.add(3);
			list.add(5);
			int size = list.size();
			System.out.printf("size : %d\n", size);
			
			list.clear();
			size = list.size();
			System.out.printf("size : %d\n", size);
			
			list.add(7);
			int num = list.get(1);
			System.out.printf("size : %d\n", num);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		map.put("1번", 350);
		map.put("2번", 250);
		map.put("3번", 350);
		System.out.println(map.get("2번"));


	}

}
