package webprj.com.newlecture.web.service;

import webprj.com.newlecture.web.entity.Pagedata;

public class Paging {
	public Pagedata page(int page) {
		Pagedata data = new Pagedata();

		data.setStart(1 + ((page)-1)*5);
		data.setEnd(5*page);
		
		
		return data;
		
		
	}
}
