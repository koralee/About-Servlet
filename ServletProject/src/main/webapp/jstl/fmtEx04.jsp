<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>timeZone </title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date() %>"/>
korea KST : 
	<fmt:formatDate value="${now }" type="both"
	 dateStyle="full" timeStyle="full"/>
	 <br><br>

UK GMT :
	<fmt:timeZone value="GMT">
	<fmt:formatDate value="${now }" type="both"
	 dateStyle="full" timeStyle="full"/>
	 </fmt:timeZone>
	 <br><br>	 
	 
	 <%
	 // 사용 가능한 timeZone 목록 출력
	 String[] ids = java.util.TimeZone.getAvailableIDs();
	 
	 for(int i=0; i<ids.length;i++){
	 out.println(ids[i]+"<br>");
	 }
	 %>
	 
	 <br><br>
	 <fmt:timeZone value="Asia/Seoul">
	<fmt:formatDate value="${now }" type="both"
	 dateStyle="full" timeStyle="full"/>
	 </fmt:timeZone>
	 
	 
	 <br><br>
	 <fmt:timeZone value="Asia/Tokyo">
	<fmt:formatDate value="${now }" type="both"
	 dateStyle="full" timeStyle="full"/>
	 </fmt:timeZone>
	 
	 
	 
	 
	 
	 
	 
</body>
</html>