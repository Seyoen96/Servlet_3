package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDTO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO != null) {
			String id = memberDTO.getId();
			if(id.equals("admin")) {
				// admin
				System.out.println("admin");
				chain.doFilter(request, response);
				
			} else {
				// 일반 회원
				System.out.println("member");
				
//				request.setAttribute("result", "권한이 없습니다");
//				request.setAttribute("path","../");
//				RequestDispatcher view = request.getRequestDispatcher("../common/result.jsp");
//				view.forward(request, response);
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
			}
			
			
		} else {
			// 로그인 X
			System.out.println("log in X");
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
