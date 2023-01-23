package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	public int removeNoticeAll(int[] ids) {

		return 0;
	}
	//오버로드를 이용한 pubNoticeAll 방식
	public int pubNoticeAll(int[] oids, int[] cids) {
		
		List<String> oidsList = new ArrayList<String>();
		for (int i = 0; i < oids.length; i++) 
			oidsList.add(String.valueOf(oids[i]));
		
		List<String> cidsList = new ArrayList<String>();
		for (int i = 0; i < cids.length; i++) 
			cidsList.add(String.valueOf(cids[i]));
		
		
		
		
		return pubNoticeAll(oidsList, cidsList);
	}
	public int pubNoticeAll(List<String> oids, List<String> cids) {
		String oidsCSV = String.join(",",oids);
		String cidsCSV = String.join(",",cids);
		return pubNoticeAll(oidsCSV, cidsCSV);
	}
	public int pubNoticeAll(String oidsCSV, String cidsCSV) {
		int result = 0;
	
		String sqlOpen = String.format("UPDATE NOTICE SET PUB=1 WHERE ID IN (%s)", oidsCSV);
		String sqlClose = String.format("UPDATE NOTICE SET PUB=0 WHERE ID IN (%s)", cidsCSV);
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			if(oidsCSV.equals("")) {
			Statement stOpen = con.createStatement();
			result += stOpen.executeUpdate(sqlOpen);
			stOpen.close();
			}
			Statement stClose = con.createStatement();
			result += stClose.executeUpdate(sqlClose);

			stClose.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int insertNotice(Notice notice) {

		int result = 0;

		String sql = "INSERT INTO NOTICE(TITLE, CONTENT, WRITER_ID, PUB, FILES) VALUES(?,?,?,?,?)";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriter_id());
			st.setBoolean(4, notice.isPub());
			st.setString(5, notice.getFiles());

			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int deleteNotice(int id) {

		return 0;
	}

	public int updateNotice(Notice notice) {

		return 0;
	}

	public List<Notice> getNoticeNewestList() {

		return null;
	}

	public List<NoticeView> getNoticeList() {

		return getNoticeList("title", "", 1);
	}

	public List<NoticeView> getNoticeList(int page) {

		return getNoticeList("title", "", page);
	}

	public List<NoticeView> getNoticeList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<NoticeView>();
		String sql = "SELECT * FROM " + "(SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE_VIEW WHERE " + field
				+ " LIKE ? ORDER BY REGDATE DESC)n) WHERE NUM BETWEEN ? AND ?";
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
				NoticeView notice = new NoticeView();
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
				notice.setCmtCount(rs.getInt("CMT_COUNT"));
				notice.setPub(rs.getBoolean("PUB"));
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

	public List<NoticeView> getNoticePubList(String field, String query, int page) {

		List<NoticeView> list = new ArrayList<NoticeView>();
		String sql = "SELECT * FROM " + "(SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE_VIEW WHERE " + field
				+ " LIKE ? ORDER BY REGDATE DESC)n) WHERE PUB=1 AND NUM BETWEEN ? AND ?";
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
				NoticeView notice = new NoticeView();
				notice.setWriter_id(rs.getString("WRITER_ID"));
				notice.setFiles(rs.getString("FILES"));
				notice.setHit(rs.getInt("HIT"));
				notice.setRegdate(rs.getDate("REGDATE"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setId(rs.getInt("ID"));
				notice.setCmtCount(rs.getInt("CMT_COUNT"));
				notice.setPub(rs.getBoolean("PUB"));
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
			if (rs.next())
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

		Notice notice = new Notice();
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
				notice.setPub(rs.getBoolean("PUB"));
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
				notice.setPub(rs.getBoolean("PUB"));
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
				notice.setPub(rs.getBoolean("PUB"));
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

	public int deleteNoticeAll(int[] ids) {
		int result = 0;
		// 배열로들어오는 문자를 넣어주는 함수가 jdbc에선 지원하지않으니 수동으로 넣어준다.
		String params = "";

		for (int i = 0; i < ids.length; i++) {
			params += ids[i];
			if (i < ids.length - 1)
				params += ",";
		}

		String sql = "DELETE NOTICE WHERE ID IN (" + params + ")";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "NEWLEC", "oracle");
			Statement st = con.createStatement();

			result = st.executeUpdate(sql);

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
