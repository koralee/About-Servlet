package com.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebListener
public class ContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 종료될때
		System.out.println("웹 어플리케이션 제거....");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 초기화 될 때
		System.out.println("웹 어플리케이션 초기화....");
	}

}
