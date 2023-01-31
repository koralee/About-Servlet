package com.test;

import java.io.*;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String readFile = "/WEB-INF/testFile.txt";
		InputStream is = getServletContext().getResourceAsStream(readFile);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body><h3>");

		String str = br.readLine();
		while(str != null) {
			out.print(str+"<br>");
			str = br.readLine();
		}
		br.close();
		out.print("</h3></body></html>");
	}
}
