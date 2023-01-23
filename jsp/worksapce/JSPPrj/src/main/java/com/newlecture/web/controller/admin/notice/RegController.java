package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.InputBuffer;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(

		fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");

		// 파일저장
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		for (Part p : parts) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize() != 0) continue;
			
			Part filepart = p;
			String fileName = filepart.getSubmittedFileName();
			InputStream fis = filepart.getInputStream();
			builder.append(fileName);
			builder.append(",");
			
			
			// 물리경로를 알려준다
			String realPath = request.getServletContext().getRealPath("/upload");
			String filePath = realPath + File.separator + fileName;
			
			File path = new File(realPath);
			if(!path.exists())
				path.mkdirs();
			
			FileOutputStream fos = new FileOutputStream(filePath);
			byte[] buf = new byte[1024];
			int size = 0;
			// 일반적으로 읽는 크기가 매우작음으로 1024byte만큼 담을수있는 버퍼를 준비
			// buf를 이용해 파일을 담는 작업을한다
			while ((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			fis.close();
		}
		builder.delete(builder.length()-1,builder.length());

		boolean pub = false;
		if (isOpen != null)
			pub = true;

		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriter_id("newlec");
		notice.setFiles(builder.toString());

		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		response.sendRedirect("list");
	}
}
