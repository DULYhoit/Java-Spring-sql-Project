package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {

	List<Notice> getlist();

	Notice get(int i);

}
