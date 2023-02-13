<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>


<%
	Cookie cookie = new Cookie("hour", "1time");
	cookie.setMaxAge(60); // 60초(1분)
	response.addCookie(cookie);
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
쿠키의 유효시간 설정
</body>
S</html>