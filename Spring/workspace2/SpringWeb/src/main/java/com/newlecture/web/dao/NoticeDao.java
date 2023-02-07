package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;

@Mapper
public interface NoticeDao {
//	컬럼명 별칭을 수정해야할때
//	@Results({
//		@Result(property = "regdate", column = "reg_date"),
//		@Result(property = "memberName", column = "member_name")
//	})
//	param을 꽂을때는 #{}(값을꽂을때) 또는 ${}(문자열을 넣고싶을때 ''가들어감) 
	@Select("select * FROM notice")
	List<Notice> getList();
	
	Notice get(int id);

}
