<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("MEMBERID", "test");
    session.setAttribute("NAME", "홍길동"); 
    
	//session.setMaxInactiveInterval(60);// (60초) 1분 후 자동으로 타임아웃!
    // 여기가 주석일 경우 web.xml에 타임아웃을 설정한 경우이다.
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
세션 정보가 저장되었습니다.
</body>
</html>