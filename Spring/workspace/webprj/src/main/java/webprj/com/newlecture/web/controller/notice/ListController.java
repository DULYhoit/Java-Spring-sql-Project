package webprj.com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import webprj.com.newlecture.web.entity.Notice;
import webprj.com.newlecture.web.service.NoticeService;
import webprj.com.newlecture.web.service.jdbc.JDBCNoticeService;


public class ListController implements Controller{
	
	private NoticeService noticeService;

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("notice.list");
		
		List<Notice> list = noticeService.getList();
		mv.addObject("list", list);
//		mv.addObject("data", "Hello Spring MVC~");
//		mv.setViewName("/WEB-INF/view/index.jsp");
		
		return mv;
	}

	

}
