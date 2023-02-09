<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.boardone.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="view/color.jsp"%>

<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");%>

<%
int count = 0;
int number = 0;
List<BoardVO> articleList = null;
BoardDAO dbPro = BoardDAO.getInstance();

count = dbPro.getArticleCount();// 전체 글수
if (count > 0) {
	articleList = dbPro.getArticles();
}
number = count;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="<%=bodyback_c%>">
	<div align="center">
		<b>글목록(전체글 : <%=count%>)
		</b>

		<table width="700">
			<tr>
				<td align="right" bgcolor="<%=value_c%>"><a
					href="writeForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		<%
		if (count == 0) {
		%>

		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
		<%
		} else {
		%>
		<table align="center" width="700" border="1" cellpadding="0"
			cellspacing="0">
			<tr height="30" bgcolor="<%=value_c%>">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조회</td>
				<td align="center" width="100">IP</td>
				</td>
			</tr>

			<%
			for (int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO) articleList.get(i);
			%>
			<tr height="30">
				<td align="center"><%=number--%></td><!-- number--는 내림차순(DB에서 desc)을 의미 -->
				
				<td width="250">
				<a href="content.jsp?num=<%=article.getNum()%>&pageNum=1"> 
				<%=article.getSubject()%></a>
				<% if(article.getReadcount() >= 20){ //조회수 20넘어가면 hot 그림이 붙게해놓음 %> 
				<img src="img/hot.gif" border="0" height="16"><%} %>
				</td>
				
				<td align="center" width="100">
				<a href="mailto:<%=article.getEmail()%>">
				<%=article.getWriter() %></a>
				</td>
				
				<td align="center" width="150">
					<%= sdf.format(article.getRegdate()) %>
				</td>
				
				<td align="center" width="50">
					<%= article.getReadcount() %>
				</td>
				
				<td align="center" width="100">
					<%= article.getIp() %>
				</td>
			</tr>
			<%
			} //End for문
			%>
		</table>
		<%
		} //End if문
		%>
	</div>
</body>
</html>