package com.newlecture.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RequestMapping("/admin/board/notice/")
@Controller("adminNoticeController")
public class NoticeController {
	@Autowired
	private NoticeService service;	
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Notice> list = service.getlist();
		
		model.addAttribute("list",list);
		return "admin.board.notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		Notice notice = service.get(1);
		
		return "admin.board.notice.detail";
	}
	
	@RequestMapping("reg")
	public String reg() {
		
		return "admin.board.notice.reg";
	}
}
