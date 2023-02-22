package com.sample;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PostPre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostPreServlet() {
    }

	
   
    
	public void init() throws ServletException {
		System.out.println("init....");
	}

	
	public void destroy() {
		System.out.println("destroy...");
	}
	
	// 선처리
	@PostConstruct
	public void initMethod() {
	    	System.out.println("initMethod...");
	 }
	 
	 // 후작업
	@PreDestroy
	public void clean() {
		System.out.println("clean.....");
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
