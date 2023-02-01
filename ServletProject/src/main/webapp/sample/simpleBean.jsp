<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	//String message = request.getParameter("message");
%>
<jsp:useBean id="msg" class = "com.sample.SimpleData"/> 
<%-- <% SimpleData msg = new SimpleData(); %> 와 동일 --%>

<jsp:setProperty property="message" name="msg"/>
<!-- msg.setMessage(); 와 동일-->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 결과</title>
</head>
<body>
<h1>자바빈즈 프로그램 결과</h1>
<font size="5">
메세지 : <jsp:getProperty property="message" name="msg"/>
 <%-- <%=message %> 와 동일  --%>
</font>
</body>
</html>