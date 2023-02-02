package webprj.com.newlecture.web.service;

import java.sql.SQLException;
import java.util.List;

import webprj.com.newlecture.web.entity.Notice;

public interface NoticeService {

	public List<Notice> getList() throws ClassNotFoundException, SQLException;

	public List<Notice> getPageList(int page) throws ClassNotFoundException, SQLException;

	public int insert(Notice notice) throws ClassNotFoundException, SQLException;

	public int update(Notice notice) throws ClassNotFoundException, SQLException;

	public int delete(int id) throws ClassNotFoundException, SQLException;

}
