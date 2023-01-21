package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	public List<Notice> getNoticeList() {

		return getNoticeList("title", "", 1);
	}

	public List<Notice> getNoticeList(int page) {

		return getNoticeList("title", "", page);
	}

	public List<Notice> getNoticeList(String field, String query, int page) {
		List<Notice> list = new ArrayList<Notice>();
		String sql = "SELECT * FROM " + "(SELECT ROWNUM NUM, n.* FROM (SELECT NOTICE.* FROM NOTICE WHERE " + field
				+ " LIKE ? ORDER BY REGDATE DESC)n) " + "WHERE NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 5);
			st.setInt(3, page * 5);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
				list.add(notice);

			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getNoticeCount() {

		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		int count = 0;
		List<Notice> list = new ArrayList<Notice>();
		String sql = "SELECT COUNT(ID) COUNT FROM " + "(SELECT ROWNUM NUM, n.* FROM (SELECT NOTICE.* FROM NOTICE WHERE "
				+ field + " LIKE ? ORDER BY REGDATE DESC)n) ";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");

			ResultSet rs = st.executeQuery();

			count = rs.getInt("COUNT");
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public Notice getNotice(int id) {

		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getnextNotice(int id) {
		Notice notice = null;
		String sql = "SELECT * FROM " + "(SELECT * FROM "
				+ "NOTICE WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=?) " + "ORDER BY ID ASC) "
				+ "WHERE ROWNUM = 1";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {
		Notice notice = null;
		
		String sql = "SELECT * FROM " + "(SELECT * FROM "
				+ "NOTICE WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=?) " + "ORDER BY ID DESC) "
				+ "WHERE ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

}
