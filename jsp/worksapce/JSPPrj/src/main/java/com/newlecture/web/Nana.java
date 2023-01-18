package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cntt = req.getParameter("cnt");
		int cnt = 100;
		
		if(cntt != null && cntt !="") {
			 cnt = Integer.parseInt(req.getParameter("cnt"));
		} 
			
		
		PrintWriter out = resp.getWriter();
		for (int i = 0; i < cnt; i++) {
			
			out.println(i+" 안녕 hello <br>");
		}
		
	}
}
