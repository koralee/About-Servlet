package com.sample;

/*  1. ServletConfig
 *      - ServletConfig 객체는 Container가 서블릿을 생성할때 생성되는 객체임
 *      - DD(web.xml)를 읽어서 이름/값의 쌍으로 된 초기 파라미터 값을 읽어서 저장함
 *      - ServletConfig 객체는 servlet 객체당 하나씩 생성됨
 *      - servlet에서는 getServletConfig()를 이용해서 Servlet과 관련된
 *        ServletConfig 객체를 얻을 수 있음
 *        
 *  2. ServletContext  
 *      - ServletContext 객체는 web application 당 하나씩 생성됨
 *       - DD(web.xml)를 읽어서 이름/값의 쌍으로 된 초기 파라미터 값을 읽어서 저장함
 *      - web application 전체에서 참조할 수 있는 초기화 파라미터를 저장함
 *      - Servlet에서는 getServletContext()를 이용해서 ServletContext 객체를 얻어옴
 * 
 *    - ServletConfig, ServletContext 
 *    
 *    <context-param>
 *          <description> 연락처</description>
 *          <param-name>tel</param-name>
 *          <param-value>010-1111-1111</param-value>
 *    </context-param>
 *    <servlet>
 *     <servlet-name>InitParam</servlet-name>
 *     <servlet-class>com.sample.InitParam</servlet-class>
 *    <init-param>
 *               <description> 연락처</description>
 *               <param-name>tel</param-name>
 *               <param-value>010-1111-1111</param-value>
 *     </init-param>
 *    </servlet>
 *     <servlet-mapping>
       <servlet-name>InitParam</servlet-name>
       <url-pattern>/InitParam</url-pattern>
       </servlet-mapping>
 */







import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "InitParam", urlPatterns = {"/InitParam"},
initParams = {
		@WebInitParam(name="tel", value = "010-1234-1234"),
		@WebInitParam(name="email", value = "hong@naver.com")
})

public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String company;
	
	private String manager;
	private String tel;
	private String email;
	
	
	public void init() throws ServletException {
		//ServletContext
		company ="global";
		//company =getServletContext().getInitParameter("company");
				//getServletContext().getInitParameter("company");
		manager ="김정섭";
	//	manager =getServletContext().getInitParameter("manager");
				//getServletContext().getInitParameter("manager");
		//ServletConfig
		
		//tel = "010-1234-1234";
		tel = getServletConfig().getInitParameter("tel");
				//getServletConfig().getInitParameter("tel");
		//email ="hong@naver.com";
		email =getServletConfig().getInitParameter("email");
				//getServletConfig().getInitParameter("email");
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li>회사명:"+company+"</li>");
		out.print("<li>관리자:"+manager+"</li>");
		out.print("<li>연락처:"+tel+"</li>");
		out.print("<li>이메일:"+email+"</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
