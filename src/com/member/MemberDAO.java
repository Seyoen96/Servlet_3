package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnect;

public class MemberDAO {
	
	//1. insert
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPwd());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone());
		st.setInt(6, memberDTO.getAge());
		
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("member insert success!");			
		} else {
			System.out.println("member insert fail!");
		}
		
		st.close();
		con.close();		
		return res;
	}
	
	//2. login (db에서 조회)
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPwd());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			//로그인 성공
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
		} else {
			//로그인 실패
			memberDTO = null;
		}
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	
}
