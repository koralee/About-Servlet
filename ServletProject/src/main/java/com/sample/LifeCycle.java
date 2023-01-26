package com.sample;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//생성자
    public LifeCycle() {
    	System.out.println("LifeCycle 생성자가 호출됨......");
    }

    
	//초기화 작업 담당.
    //객체 생성시 단 한 번만! 호출된다.
	public void init() throws ServletException {
		System.out.println("init() 메소드 호출......");
	}

	//종료 작업 담당.
	//LifeCycle의 객체가 WAS(Web Appliction System)에서 소멸될 때 호출되는 메소드
	public void destroy() {
		System.out.println("destroy() 메소드 호출......");
	}

	//클라이언트의 요청(연결)이 발생될 때 마다 호출되는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service() 메소드 호출......");
	}

}
