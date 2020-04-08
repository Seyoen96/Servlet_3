package com.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PointService pointService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        pointService = new PointService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		String method = request.getMethod();
		
		//Forward(true), redirect(false) 선택
		boolean check = true;
		
		//path 담을 변수
		String path = "";
		try {		
		//list
		if(command.equals("/pointList")) {
			
				ArrayList<PointDTO> ar = pointService.pointList();
				request.setAttribute("list", ar);
			 
			path ="../WEB-INF/views/point/pointList.jsp";

			
			
		//add	
		} else if(command.equals("/pointAdd")) {
			if(method.equals("POST")) {
				//DB에 저장
				path = "../WEB-INF/views/point/pointAdd.jsp";
				
			} else {
				//redirect로 point/pointList로 이동
//				check = false;
//				path="../point/pointList";
				path = "../WEB-INF/views/point/pointAdd.jsp";
				
//				PointDTO pointDTO = null;
//				
//				pointDTO.setName(request.getParameter("name"));
//				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
//				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
//				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
//				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
//				pointDTO.setTotal(Integer.parseInt(request.getParameter("total")));
//				pointDTO.setAvg(Double.parseDouble(request.getParameter("avg")));
//				
//				pointService.pointAdd(pointDTO);
				
			}
		
			
			
			
			
		//mod
		} else if (command.equals("/pointMod")) {
			if(method.equals("POST")) {
				
			} else {
				path ="../WEB-INF/views/point/pointMod.jsp";
			}
		
		//select
		} else if(command.equals("/pointSelect")) {
			int num = Integer.parseInt(request.getParameter("num"));
			PointDTO pointDTO = pointService.pointSelect(num);
			request.setAttribute("dto", pointDTO);
			path = "../WEB-INF/views/point/pointSelect.jsp";
		
		//delete
		} else if (command.equals("/pointDel")) {
			int num = Integer.parseInt(request.getParameter("num"));
			int res = pointService.pointDel(num);
			System.out.println(res+"개 삭제 완료");
			
			//redirect로 point/pointList로 이동
			check = false;
			path="../point/pointList";
			
		
		} else {
			System.out.println("etc.");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
					
		} else {
			response.sendRedirect(path);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
