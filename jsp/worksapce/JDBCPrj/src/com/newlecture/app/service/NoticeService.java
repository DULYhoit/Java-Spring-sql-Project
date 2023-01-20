package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.entity.Pagedata;

public class NoticeService {
	public List<Notice> getList() throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Notice> list = new ArrayList<Notice>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String file = rs.getString("FILES");
			Notice notice = new Notice(id, title, writer_id, content, regdate, hit, file);
			list.add(notice);
//			System.out.println(id+" "+ title+" "+ writer_id+" "+ content+" "+ regdate+" "+ hit);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}
	
	public List<Notice> getPageList(int page) throws ClassNotFoundException, SQLException {
		Paging paging = new Paging();
		Pagedata pagedata = paging.page(page);
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE ORDER BY ID)n) WHERE NUM BETWEEN ? AND ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pagedata.getStart());
		st.setInt(2, pagedata.getEnd());
		ResultSet rs = st.executeQuery();
	
		List<Notice> list = new ArrayList<Notice>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String file = rs.getString("FILES");
			Notice notice = new Notice(id, title, writer_id, content, regdate, hit, file);
			list.add(notice);
//			System.out.println(id+" "+ title+" "+ writer_id+" "+ content+" "+ regdate+" "+ hit);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writer_id = notice.getWriter_id();
		String content = notice.getContent();
		int hit = notice.getHit();

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO NOTICE(TITLE,WRITER_ID,CONTENT,HIT)" + " VALUES(?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, writer_id);
		ps.setString(3, content);
		ps.setInt(4, hit);
		int update = ps.executeUpdate();

		ps.close();
		con.close();

		return update;
	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		int id = notice.getId();
		String content = notice.getContent();

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE SET CONTENT=? WHERE ID=?" + " VALUES(?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, content);
		ps.setInt(2, id);

		int update = ps.executeUpdate();

		ps.close();
		con.close();

		return update;

	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		int update = ps.executeUpdate();

		ps.close();
		con.close();

		return update;
	}
}