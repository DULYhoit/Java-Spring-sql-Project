package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//계산기를 위한 동적인페이지
				PrintWriter out = resp.getWriter();
				Cookie[] cookies = req.getCookies();
				
				String exp = "0";
				if(cookies != null)
				for (Cookie c : cookies) 
					if (c.getName().equals("exp")) {
						exp = c.getValue();
						
						break;
					}
				
				
				out.write("<!DOCTYPE html>");
				out.write("<html>");
				out.write("<head>");
				out.write("<meta charset=\"UTF-8>\">");
				out.write("<title>Insert title here</title>");
				out.write("<style>");
				out.write("input{");
				out.write("width: 50px;");
				out.write("height: 50px;");
				out.write("}");
				out.write(".output{");
				out.write("height: 50px;");
				out.write("background: #e9e9e9;");
				out.write("font-size: 24px;");
				out.write("font-weight: bold;");
				out.write("text-align: right;");
				out.write("padding: 0px 5px;");
				out.write("}");
				out.write("</style>");
				out.write("</head>");
				out.write("<body>");
				out.write("<form method=\"post\">");

				out.write("<table>");
				out.write("<tr>");
				out.printf("<td class=\"output\" colspan=\"4\">%s</td>",exp);
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"÷\" /></td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"x\" /></td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
				out.write("<td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
				out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
							
				out.write("</tr>");

				out.write("</table>");

				out.write("</form>");
				out.write("</body>");
				out.write("</html>");
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();

		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");

		String exp = "";

		System.out.println(exp);
		if (cookies != null)
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
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
		
		expCookie.setPath("/calculator");
		resp.addCookie(expCookie);
		resp.sendRedirect("calculator");
	
	}
}
