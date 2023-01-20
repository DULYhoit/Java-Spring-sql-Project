package ex1;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;
import com.newlecture.app.service.Paging;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeService n = new NoticeService();
		List<Notice> list = n.getPageList(1);
		
//		List<Notice> list = n.getList();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}

//		Notice notice = new Notice();
//		notice.setWriter_id("아무아무개");
//		notice.setTitle("테스트입니다");
//		notice.setContent("테스트");
//		notice.setHit(30);
//		n.insert(notice);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			list.get(i).toString();
		}
	}

}
