package com.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리(==인코딩 셋팅)
		//요청
		//setCharacterEncoding 는 request에서만 사용가능!
		request.setCharacterEncoding("UTF-8");
		Enumeration<String> enu = request.getParameterNames();
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		out.println("<html><body>");
		out.println("<h3>");
		while(enu.hasMoreElements()) {
			//이름 갖고옴
			String name = enu.nextElement();
			//이름에 있는 값을 갖고옴
			String value = request.getParameter(name);
			out.print(name+" : "+value+"<br>");
		}
		out.println("</h3>");
		out.println("</body></html>");
	
	}
}
