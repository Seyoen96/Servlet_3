package com.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnect;

import oracle.jdbc.proxy.annotation.Pre;

public class PointDAO {
	//DAO (Data Access Object)
	

	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		//1. DB 연결	
		Connection con = DBConnect.getConnect();
		//2. SQL문 작성
		String sql = "SELECT * FROM POINT ORDER BY NUM ASC";
		//3. SQL문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 세팅
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			PointDTO pointDTO = new PointDTO();
			
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			ar.add(pointDTO);
		}
		//6. 자원 해제
		st.close();
		con.close();		
		return ar;
	}
	
	//2. Select
	public PointDTO pointSelect(int num) throws Exception {
		PointDTO pointDTO = null;
		Connection con = DBConnect.getConnect();
		
		String sql = "SELECT * FROM POINT WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			pointDTO = new PointDTO();
			
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
		}
		rs.close();
		st.close();
		con.close();
		return pointDTO;
	}
	
	//3. Insert
	public int pointAdd(PointDTO pointDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "INSERT INTO POINT VALUES (?,?,?,?,?,?,?)";	
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointDTO.getName());
		st.setInt(2, pointDTO.getNum());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		
		st.close();
		con.close();
		return res;
	}

	
	
	
	//4. Update
	public int pointMod(PointDTO pointDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "UPDATE POINT SET NAME=?, KOR=?, ENG=?, MATH=?, TOTAL=?, AVG=?  WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, pointDTO.getName());
		st.setInt(2, pointDTO.getKor());
		st.setInt(3, pointDTO.getEng());
		st.setInt(4, pointDTO.getMath());
		st.setInt(5, pointDTO.getTotal());
		st.setDouble(6, pointDTO.getAvg());

		st.setInt(7, pointDTO.getNum());
		
		
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("update 성공");
		} else {
			System.out.println("update 실패");
		}
		
		st.close();
		con.close();
		
		return res;
	}
	
	
	
	//5. Delete
	public int pointDel(int num) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "DELETE POINT WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		int res = st.executeUpdate();
		if(res>0) {
			System.out.println("delete 성공");
		} else {
			System.out.println("delete 실패");
		}
		
		st.close();
		con.close();
		return res;
	}
	
	
		

}
