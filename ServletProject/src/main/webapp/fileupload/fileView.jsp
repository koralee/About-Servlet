<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,
com.oreilly.servlet.multipart.DefaultFileRenamePolicy,
java.util.*"%>

<%
String realFolder = "";
String saveFolder = "upload";
String encType = "UTF-8";
int maxSize = 10 * 1024 * 1024; //10메가바이트
ServletContext context = getServletContext();
realFolder = context.getRealPath(saveFolder);

ArrayList saveFiles = new ArrayList();
ArrayList origFiles = new ArrayList();

String paramUser = "";
String paramTitle = "";
String paramAbstract = "";

try {
	MultipartRequest multi = new MultipartRequest(
			request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

	paramUser = multi.getParameter("txtUser");
	paramTitle = multi.getParameter("txtTitle");
	paramAbstract = multi.getParameter("txtAbstract");
		
		// 폼요소 중 file속성으로 지정된 input태크의 이름을 의미함.
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()){
			String name = (String)files.nextElement();
			saveFiles.add(multi.getFilesystemName(name)); // 서버에 저장
			origFiles.add(multi.getOriginalFileName(name));// 사용자가 올린 파일을 저장
		}
		
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table width="75%" border="1" align="center" cellpadding="1"
cellspacing="1" bordercolor="#600" bgcolor="#ff9">
	<tr>
		<td width="10%" bgcolor="#fc0">
			<div align="right"><Strong>user</Strong></div>
		</td>
		<td width="30%"><%=paramUser %></td>
		
		<td width="10%" bgcolor="#fc0">
			<div align="right"><Strong>title</Strong></div>
		</td>
		<td width="30%"><%=paramTitle %></td>
	</tr>
	
	<tr>
		<td width="10%" bgcolor="#fc0">
			<div align="right"><Strong>Abstract</Strong></div>
		</td>
		<td width="50%" colspan="3">
			<textarea rows="5" cols="50"><%=paramAbstract %></textarea>
		</td>
	</tr>
	
	<tr><td colspan="4" bgcolor="#fff">&nbsp;</td></tr>
	
	<tr><td colspan="4"><strong>업로드된 파일들입니다.</strong></td></tr>
	
	<%
	for(int i =0;i<saveFiles.size();i++){
	%>
	<tr bgcolor="#fc0">
		<td colspan="4">
			<a href="<%= "/ServletProject/"+saveFolder+"/"+saveFiles.get(i)%>">
			<strong><%=origFiles.get(i) %></strong></a>
		</td>
	</tr>
	<%} %>
</table>
</body>
</html>
<%
	} catch (IOException ioe) {
		System.out.println(ioe);
	} catch (Exception e) {
		System.out.println(e);
	}
%>
