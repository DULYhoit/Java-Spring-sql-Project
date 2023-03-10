package webprj.com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import webprj.com.newlecture.web.entity.Notice;
import webprj.com.newlecture.web.entity.Pagedata;
import webprj.com.newlecture.web.service.NoticeService;
import webprj.com.newlecture.web.service.Paging;



public class JDBCNoticeService implements NoticeService{
//	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//	String uid = "NEWLEC";
//	String pwd = "oracle";
//	String driver = "oracle.jdbc.driver.OracleDriver";
	
	@Autowired
	private DataSource dataSource;

	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM NOTICE";
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
		Connection con = dataSource.getConnection();
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
		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
		Connection con = dataSource.getConnection();
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE ORDER BY ID)n) WHERE NUM BETWEEN ? AND ?";
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

//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
		Connection con = dataSource.getConnection();
		String sql = " INSERT INTO NOTICE(TITLE,WRITER_ID,CONTENT,HIT)" + " VALUES(?,?,?,?)";
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

//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
		Connection con = dataSource.getConnection();
		String sql = "UPDATE NOTICE SET CONTENT=? WHERE ID=?" + " VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, content);
		ps.setInt(2, id);

		int update = ps.executeUpdate();

		ps.close();
		con.close();

		return update;

	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
		Connection con = dataSource.getConnection();
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		int update = ps.executeUpdate();

		ps.close();
		con.close();

		return update;
	}
}