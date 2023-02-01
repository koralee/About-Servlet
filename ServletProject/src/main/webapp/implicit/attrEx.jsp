<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// pageContext(해당JSP 페이지 내에서만 사용가능)
// Scope 에 속성 저장
pageContext.setAttribute("pageAttribute", "홍길동"); // (key값, value값)
// pageContext.setAttribute("pageAttribute", "홍길동", pageContext.PAGE_SCOPE);

// request Scope에 속성 저장
// application에서request에 접근 가능한 것들을 의미함.
request.setAttribute("requestAttribute", "hong@naver.com"); // (key값, value값)
// pageContext.setAttribute("pageAttribute", "홍길동", pageContext.REQUEST_SCOPE);

// session Scope에 속성 저장
// Servlet이나 JSP의 객체를 생존(=클라이언트의 상태 정보)의 유지
session.setAttribute("sessionAttribute", "010-1234-5678"); // (key값, value값)
// pageContext.setAttribute("pageAttribute", "홍길동", pageContext.SESSION_SCOPE);

//application Scope에 속성저장
// 웹 어플리케이션 내의 모든 것들
application.setAttribute("applicationAttribute", "Global-In"); // (key값, value값)
pageContext.setAttribute("pageAttribute", "홍길동", pageContext.APPLICATION_SCOPE);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>이름 : <%=pageContext.getAttribute("pageAttribute")%></li>
		<li>메일 : <%=request.getAttribute("requestAttribute")%></li>
		<li>전화 : <%=session.getAttribute("sessionAttribute")%></li>
		<li>회사 : <%=application.getAttribute("applicationAttribute")%></li>
	</ul>
</body>
</html>