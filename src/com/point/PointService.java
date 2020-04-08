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
		return pointDAO.pointAdd(pointDTO);
	}
	
}
