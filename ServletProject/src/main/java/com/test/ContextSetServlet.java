package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextSetServlet
 */
@WebServlet("/ContextSet")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//속성 값 설정
		String name = "홍길동";
		int age = 20;
		
		getServletContext().setAttribute("name", name); //(키값, 변수값(즉==홍길동)
		getServletContext().setAttribute("age", age);
		
	}
}
