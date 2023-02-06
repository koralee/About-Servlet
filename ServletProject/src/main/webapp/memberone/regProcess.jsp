<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO"/>
<jsp:useBean id="vo" class="com.memberone.StudentVO"/>
<jsp:setProperty property="*" name="vo"/>


<%
	boolean flag = dao.memberInsert(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFC">
<br>
<div align="center">
<% 
if(flag){
	out.println("<b>회원 가입이 정상적으로 완료되었습니다.</b><br>");
	out.println("<a href =login.jsp>로그인</a>");
}else{
	out.println("<b>회원 가입 실패/ 다시 입력해 주십시오.</b><br>");
	out.println("<a href =regForm.jsp>다시입력</a>");
}
%>
</div>
</body>
</html>