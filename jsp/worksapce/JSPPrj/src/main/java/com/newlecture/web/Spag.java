package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //jsp의 스파게티코드를 model2 로변경
		int num = 2;
	    String num_ = req.getParameter("n");
	    if( num_ != null && !num_.equals(""))
	    	num = Integer.parseInt(num_);

	    	String result;
	    	
	    	if(num%2 != 0)
	    		result = "홀수";
	    	else
	    		result = "짝수";
	    	
	    	req.setAttribute("result", result);
	    	
	    	String[] names = {"newlec", "dragon","kim"};
	    	req.setAttribute("names", names);
	    	
	    	Map<String, Object> notice = new HashMap<String,Object>();
	    	notice.put("id", 1);
	    	notice.put("title", "El은 좋아요");
	    	req.setAttribute("notice", notice);
	    	
		//redirect - 새로운요청
	    //forward -현재작업한내용을 이어간다
	    	
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
	    	dispatcher.forward(req, resp);
	}
}
