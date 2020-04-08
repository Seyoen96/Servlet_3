package com.point;

import java.util.ArrayList;

public class PointService {
	private PointDAO pointDAO;
	public PointService(){
		this.pointDAO = new PointDAO();
	}
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
	}
	
	//2. Select
	public PointDTO pointSelect(int num) throws Exception{
		return pointDAO.pointSelect(num);
	}
	
	//3. Delete
	public int pointDel(int num) throws Exception{
		return pointDAO.pointDel(num);
	}

	//4. Insert
	public int pointAdd(PointDTO pointDTO) throws Exception{
		
//		pointDTO.setName(request.getParameter("name"));
//		pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
//		pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
//		pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
//		pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
//		pointDTO.setTotal(Integer.parseInt(request.getParameter("total")));
//		pointDTO.setAvg(Double.parseDouble(request.getParameter("avg")));
		return pointDAO.pointAdd(pointDTO);
	}
	
}
