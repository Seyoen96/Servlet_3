package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnect;

public class NoticeDAO {
	
	//1. Notice List
	public ArrayList<NoticeDTO> noticeList() throws Exception {		
		Connection con = DBConnect.getConnect();
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		String sql="SELECT * FROM NOTICE";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSub(rs.getString("sub"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setNodate(rs.getDate("nodate"));
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		con.close();
		return ar;
	}
	
	//2. Notice Select
	public NoticeDTO noticeSelect(int no) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "SELECT * FROM NOTICE WHERE NO=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		System.out.println(no);
		
		ResultSet rs = st.executeQuery();
		
		NoticeDTO noticeDTO = new NoticeDTO();
		while(rs.next()) {
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSub(rs.getString("sub"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setNodate(rs.getDate("nodate"));			
		}
	
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
	}
	
	//3. Notice Update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "UPDATE NOTICE SET SUB=?, CONTENTS=?, NODATE=SYSDATE"
				+ "WHERE NO=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getSub());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNo());
		int res = st.executeUpdate();
		
		if(res>0) {
			System.out.println("글 수정 완료");
		} else {
			System.out.println("글 수정 실패");
		}
		
		st.close();
		con.close();
		return res;
	}
	

}
