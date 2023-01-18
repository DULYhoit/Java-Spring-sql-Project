package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain Chain)
			throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8"); //응답으로 보내는 인코딩을 UTF-8로 바꿈
		response.setContentType("text/html; charset=UTF-8");//브라우저에게 UTF-8로 해석하라
		request.setCharacterEncoding("UTF-8");
			Chain.doFilter(request, response);
			
	}

}
