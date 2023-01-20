package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//현재 jdbc를 지원하지않는 버전이 많음 따라서 jdbc는 1.8버전으로 만듦
		//1.Statement 집계결과를 담을수있는 ResultSet 으로 고정된 sql문을 실행할수있음
		//2.PreparedStatement 기존 Connection 에서 sql구문의 값을 유동적으로 집어넣을수 있게한다
		//2번같은경우는 executeQuery(반환타입 집계결과) , executeUpdate(반환타입 int) 둘로 나뉘어진다
		//
		String title = "Test2";
		String writer_id = "Test2";
		String content = "Test2";
		String hit = "23";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO NOTICE(TITLE,WRITER_ID,CONTENT,HIT)"
				+ " VALUES(?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url ,"NEWLEC", "oracle");
//		Statement st = con.createStatement();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, writer_id);
		ps.setString(3, content);
		ps.setString(4, hit);
		int update = ps.executeUpdate();
		
//		ResultSet rs = st.executeQuery(sql);
		
		
//		while(rs.next()) {
//			int id =rs.getInt("ID");
//			String title =rs.getString("TITLE");
//			String writer_id =rs.getString("WRITER_ID");
//			String content =rs.getString("CONTENT");
//			Date regdate =rs.getDate("REGDATE");
//			int hit =rs.getInt("HIT");
//			System.out.println(id+" "+ title+" "+ writer_id+" "+ content+" "+ regdate+" "+ hit);
//		}
		
		
//		rs.close();
//		st.close();
		ps.close();
		con.close();
		
		
	

	}

}
