package webprj.com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import webprj.com.newlecture.web.entity.Notice;
import webprj.com.newlecture.web.service.NoticeService;
import webprj.com.newlecture.web.service.jdbc.JDBCNoticeService;

@org.springframework.stereotype.Controller
@RequestMapping("/customer/notice/")
public class NoticeController{
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("list")
	public String list(@RequestParam(name = "p",defaultValue = "1") int page) throws ClassNotFoundException, SQLException {
		List<Notice> list = noticeService.getList();
		System.out.println(page);
		return "notice.list";
	}
	@RequestMapping("detail")
	public String detail() {
	
		return "notice.detail";
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mv = new ModelAndView("notice.list");
//		
//		List<Notice> list = noticeService.getList();
//		mv.addObject("list", list);
//		mv.addObject("data", "Hello Spring MVC~");
//		mv.setViewName("/WEB-INF/view/index.jsp");
//		
//		return mv;
//	}

	

}
