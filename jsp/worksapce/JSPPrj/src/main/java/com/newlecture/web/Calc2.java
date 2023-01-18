package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Application, Session, cookie 을 이용한 데이터저장방법

		PrintWriter out = resp.getWriter();
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();

		// 쿼리스트링으로 value 값과 +,-,= 중하나를 가져온다
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		int v = 0;
		if (!v_.equals(""))
			v = Integer.parseInt(v_);
		// 계산
		if (op.equals("=")) {

//			int x = (Integer)application.getAttribute("value"); 담아놨던 이전 데이터
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			
			for (Cookie c : cookies) 
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			
			int y = v;// 이전 value값
//			String operator = (String) application.getAttribute("op");
//			String operator = (String) session.getAttribute("op");
			String operator = "";
			for (Cookie c : cookies) 
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			if (operator.equals("+"))
				result = x + y;
			else
				result = x - y;

			resp.getWriter().printf("result is %d\n", result);
		}
		// 저장
		else {

//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			Cookie valuecookie = new Cookie("value", String.valueOf(v));
			Cookie opcookie = new Cookie("op", op);
			valuecookie.setPath("/calc2");//쿠키를 보낼 주소
			opcookie.setPath("/calc2");
			valuecookie.setMaxAge(24*60*60);
			opcookie.setMaxAge(24*60*60);
			resp.addCookie(valuecookie);
			resp.addCookie(opcookie);
			
			resp.sendRedirect("calc2.html");
		}

	}
}
