package com.newlecture.app.service;

import com.newlecture.app.entity.Pagedata;

public class Paging {
	public Pagedata page(int page) {
		Pagedata data = new Pagedata();

		data.setStart(1 + ((page)-1)*5);
		data.setEnd(5*page);
		
		
		return data;
		
		
	}
}
