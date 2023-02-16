<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소스 코드 보기</title>
</head>
<body>
<!-- 주소창에 ?path=/jstl/forEx01.jsp(아무파일 경로) 입력하면 소스코드 뜸! -->
	<%
	FileReader reader = null;
	
	try{
		String path = request.getParameter("path");
		reader = new FileReader(getServletContext().getRealPath(path));
	%>
	<pre>
	소스 코드 = <%=path %>
	<c:out value="<%=reader %>"/>
	</pre>
<%}catch(IOException ex){ %>
에러 : <%=ex.getMessage() %>
<%}finally{ 
	if(reader != null){
		try{
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
	%>
</body>
</html>