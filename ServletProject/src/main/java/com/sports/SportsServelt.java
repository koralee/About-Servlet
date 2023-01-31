package com.sports;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sport")
public class SportsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post방식은 인코딩 먼저 셋팅해줘야 함.
		request.setCharacterEncoding("UTF-8");
		String[] Sport = request.getParameterValues("sports");
		String gender = request.getParameter("gender");

		// 값을 끌고와 화면에 뿌려주기 위해 셋팅하는 부분(즉 반응을 받아오는 부분)
		// 갖고오는 부분의 ContentType을 셋팅!(요청해서 응답 할 때)
		response.setContentType("text/html;charset=UTF-8");
		// 메소드를 객체로 설정
		PrintWriter out = response.getWriter();

		// out을 사용해서 화면에 뿌려줌!(HTML 형식으로)
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		for(String AA : Sport ) {
		out.print("좋아하는 운동 : " +AA + "<br>");
		}
		
		out.println("성별 : " + gender + "<br>");
		
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
	}

}
