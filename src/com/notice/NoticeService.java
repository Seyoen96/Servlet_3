package com.notice;

import java.util.ArrayList;

public class NoticeService {
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	// List
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		return noticeDAO.noticeList();
	}
	
	// Select
	public NoticeDTO noticeSelect(int no) throws Exception{
		return noticeDAO.noticeSelect(no);
	}
	
	// Modify
	public int noticeMod(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeMod(noticeDTO);
	}
	

}
