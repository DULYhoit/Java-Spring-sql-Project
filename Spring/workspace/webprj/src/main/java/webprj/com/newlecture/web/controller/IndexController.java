package webprj.com.newlecture.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("data", "Hello Spring MVC~");
//		mv.setViewName("/WEB-INF/view/index.jsp");
		return mv;
	}

}
