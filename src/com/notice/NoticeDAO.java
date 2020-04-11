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
		String sql="SELECT * FROM NOTICE ORDER BY NO DESC";
		
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
		String sql = "UPDATE NOTICE SET SUB=?, CONTENTS=? WHERE NO=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getSub());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNo());

		int res = st.executeUpdate();
		
		st.close();
		con.close();
		return res;
	}
	
	//4. Notice Delete
	public int noticeDelete(int no) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql="DELETE NOTICE WHERE NO = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, no);
		int res = st.executeUpdate();
		
		st.close();
		con.close();
		return res;
	}
	
	
	//5. Notice Add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "INSERT INTO NOTICE VALUES (SEQ_NOTICE_NO.NEXTVAL,"
				+ "?,?,SYSDATE)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getSub());
		st.setString(2, noticeDTO.getContents());
		int res = st.executeUpdate();
		
		st.close();
		con.close();
		return res;
	}
	
	
	
	

}
