package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        memberService = new MemberService();
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
		String path="";
		
		try {
		//로그인 후 계속 유지되는 정보 		-> session 
		//한번 받고 사라져도 되는 정보 이용 		-> request	
			
		//1. member Join
		if(command.equals("/memberJoin")) {
			if(method.equals("POST")) {
				String msg ="회원가입 실패";
				
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPwd(request.getParameter("pwd"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				int res = memberService.memberJoin(memberDTO);
				
				if(res>0) {
					msg="회원 가입 완료!";
				}
				request.setAttribute("result", msg);
				request.setAttribute("path", "../");
				path="../WEB-INF/views/common/result.jsp";
			} else {
				path = "../WEB-INF/views/member/memberJoin.jsp";
			}
			
			
			
		//2. member Login	
		} else if(command.equals("/memberLogin")) {
			
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPwd(request.getParameter("pwd"));
				memberDTO = memberService.memberLogin(memberDTO);
				
				if(memberDTO!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					check = false;
					path = "../";					
				} else {
					//로그인 실패 시 로그인 form으로
					request.setAttribute("result", "로그인 실패");
					request.setAttribute("path", "./memberLogin");
					path = "../WEB-INF/views/common/result.jsp";
				}	
			}else {
				path = "../WEB-INF/views/member/memberLogin.jsp";			
			}
			
			
		//3. logout	
		} else if(command.equals("/memberLogout")) {
			HttpSession session = request.getSession();
			//session.removeAttribute("member");
			session.invalidate();
			check = false;
			path ="../";
		}
		
		//4. MyPage
		else if (command.equals("/memberPage")) {	
			
			path="../WEB-INF/views/member/memberPage.jsp";
		
			
		//5. member update	
		} else if(command.equals("/memberUpdate")) {
			if(method.equals("POST")) {
				HttpSession session = request.getSession();
				
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPwd(request.getParameter("pwd"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				
				int res = memberService.memberUpdate(memberDTO);
			
				if(res>0) {
					//session에 수정된 데이터 다시 set
					session.setAttribute("member", memberDTO);
				}
				
				check = false;
				path="./memberPage";
				
			} else {
				path="../WEB-INF/views/member/memberUpdate.jsp";				
			}
		
			
		//6. member delete	
		} else if(command.equals("/memberDelete")) {
			HttpSession session = request.getSession();
			
			MemberDTO memberDTO = new MemberDTO();			
			memberDTO=(MemberDTO)session.getAttribute("member");	
			
			memberService.memberDelete(memberDTO);
			session.invalidate();
			check=false;
			path="../";	
			
		} else {
			System.out.println("etc.");
		}
		
		
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
