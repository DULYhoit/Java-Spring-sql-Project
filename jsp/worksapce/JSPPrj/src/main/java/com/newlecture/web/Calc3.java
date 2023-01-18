package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.util.Iterator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();

		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");

		String exp = "";
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					System.out.println(exp);
					break;
				}
		if (operator != null && operator.equals("=")) {
			// 꼼수 자바스크립트를 실행시켜주는 라이브러리
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				// engine.eval은 연산식그대로 계산해주는 스크립트
				// 현재 nashorn 은 특정 jdk버전에서 삭제됨..... 코드는 완성하였으나 engine이 null값을 반환함
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (operator != null && operator.equals("C")) {
			exp = "";
		} else {
			// 연산자를 입력안하고 연속으로 숫자를 눌렀을때 누적
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}

		Cookie expCookie = new Cookie("exp", exp);
		if (operator != null && operator.equals("C"))
			expCookie.setMaxAge(0);// 쿠키가 바로소멸됨
		expCookie.setPath("/calc");
		resp.addCookie(expCookie);
		resp.sendRedirect("calcpage");

	}
}
