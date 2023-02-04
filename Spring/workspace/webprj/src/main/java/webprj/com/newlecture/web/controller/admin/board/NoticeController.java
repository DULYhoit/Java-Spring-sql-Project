package webprj.com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	@RequestMapping("list")
	public String list() {
		
		return null;
	}
	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, String[] foods) {
		
		return String.format("title:%s<br>content:%s",title,content);
	}
	@RequestMapping("adit")
	public String adit() {
		
		return null;
	}
	@RequestMapping("del")
	public String del() {
		
		return null;
	}

}
