package com.newlecture.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer/notice/")
@Controller
public class NoticeController {
	
	@RequestMapping("list")
	public String list(Model model) {
		
		model.addAttribute("test","hello DEV TOOLS");
		return "customer/notice/list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		return "customer/notice/detail";
	}
}
