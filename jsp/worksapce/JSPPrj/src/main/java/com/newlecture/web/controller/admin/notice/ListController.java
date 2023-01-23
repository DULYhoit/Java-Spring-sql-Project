package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {
	public ListController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}
		String query = "";
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}
		int page = 1;
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);

		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split(" ");
		NoticeService service = new NoticeService();
		
		switch (cmd) {
		case "open":
			
			//openIds에대한 리스트
			List<String> oids = Arrays.asList(openIds);
			//openIds의 리스트에서  전체 아이디에서 빼준다
			List<String> cids =  new ArrayList<String>(Arrays.asList(ids));
			cids.removeAll(oids);
			//만약 openids 가 null이면?

		
			service.pubNoticeAll(oids,cids);
					
				
			break;
		case "close":
			
			int[] ids1 = new int[delIds.length];
			for (int i = 0; i < delIds.length; i++) 
				ids1[i] = Integer.parseInt(delIds[i]);
			
			
			int result = service.deleteNoticeAll(ids1);
			break;
		}
		response.sendRedirect("list");
		}
		
	}

