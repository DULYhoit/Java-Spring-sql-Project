package webprj.com.newlecture.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class HomeController{
	
	@RequestMapping("index")
	public String index() {
		
		return "root.index";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mv = new ModelAndView("root.index");
//
//		return mv;
//	}



}
