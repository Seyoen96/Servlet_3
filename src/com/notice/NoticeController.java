package com.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDTO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        noticeService = new NoticeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		String method = request.getMethod();
		boolean check = true;
		String path = "";
		
		try {

		// 글 목록 페이지
		if(command.equals("/noticeList")) {	
			String id = request.getParameter("id");
			String type = "";
			
			if(!id.isEmpty()) {
				type = "hidden";	
				
				ArrayList<NoticeDTO> ar = noticeService.noticeList();
				request.setAttribute("noticeList", ar);
				path = "../WEB-INF/views/notice/noticeList.jsp";
				
				if(id.equals("admin")) {
					//admin 로그인
					type = "button";
				}
				request.setAttribute("type", type);

			} else {
				//로그아웃 상태
				request.setAttribute("result", "권한이 없습니다");
				request.setAttribute("path", "../");
				path = "../WEB-INF/views/common/result.jsp";
			}


		// 상세 페이지
		} else if (command.equals("/noticeSelect")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String id = request.getParameter("id");
			String type = "hidden";
			
			NoticeDTO noticeDTO = noticeService.noticeSelect(no);
			request.setAttribute("noDto", noticeDTO);
			
			// admin일 때
			if(id.equals("admin")) {
				type="button";
			}			
			request.setAttribute("type", type);
			
			path="../WEB-INF/views/notice/noticeSelect.jsp";
		
			
		// 글 수정 페이지
		} else if (command.equals("/noticeMod")) {
			
			if(method.equals("POST")) {			
				NoticeDTO noticeDTO = new NoticeDTO();			
				noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));	
				noticeDTO.setSub(request.getParameter("sub"));
				noticeDTO.setContents(request.getParameter("contents"));	
				
				int res = noticeService.noticeMod(noticeDTO);				
					
				check = false;
				path = "../notice/noticeList?id=admin";
			} else {
				int no = Integer.parseInt(request.getParameter("no"));
				NoticeDTO noticeDTO = noticeService.noticeSelect(no);
				request.setAttribute("noDto", noticeDTO);
				
				path="../WEB-INF/views/notice/noticeMod.jsp";
			}
			
		
		// 글 삭제 페이지	
		} else if(command.equals("/noticeDelete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			noticeService.noticeDelete(no);
			
			check = false;
			path = "../";
			
			
		// 새 글 쓰기
		} else if(command.equals("/noticeAdd")) {
			if(method.equals("POST")) {
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setSub(request.getParameter("sub"));
				noticeDTO.setContents(request.getParameter("contents"));
				noticeService.noticeAdd(noticeDTO);
				
				check = false;
				path="../";
			} else {
				path = "../WEB-INF/views/notice/noticeAdd.jsp";
			}
			
		} else {
			System.out.println("etc.");
		}
		
		
		//redirect or forward
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
					
		} else {
			response.sendRedirect(path);
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
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
