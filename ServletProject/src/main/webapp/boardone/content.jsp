<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.boardone.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="view/color.jsp"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

try {
	BoardDAO dbPro = BoardDAO.getInstance();
	BoardVO article = dbPro.getArticle(num);

	int ref = article.getRef();
	int step = article.getStep();
	int depth = article.getDepth();
%>

<body bgcolor="<%=bodyback_c%>">
	<div align="center">
		<b>상세 보기</b><br>
		<form action="">
			<table width="500" border="1" cellpadding="0" cellspacing="0"
				align="center" bgcolor="<%=bodyback_c%>">

				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_c%>">글번호</td>
					<td align="center" width="125"><%=article.getNum()%></td>

					<td align="center" width="125" bgcolor="<%=value_c%>">조회수</td>
					<td align="center" width="125"><%=article.getReadcount()%></td>
				</tr>

				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_c%>">작성자</td>
					<td align="center" width="125"><%=article.getWriter()%></td>

					<td align="center" width="125" bgcolor="<%=value_c%>">작성일</td>
					<td align="center" width="125"><%=sdf.format(article.getRegdate())%></td>
				</tr>

				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_c%>">글제목</td>
					<td align="center" width="375" colspan="3"><%=article.getSubject()%></td>
				</tr>

				<tr height="30">
					<td align="center" width="125" bgcolor="<%=value_c%>">내용</td>
					<td align="left" width="375" colspan="3"><pre><%=article.getContent()%></pre>
					</td>
				</tr>

				<tr height="30">
					<td colspan="4" bgcolor="<%=value_c%>" align="right">
					<input type="button" value="수정" 
					onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="button" value="삭제" 
					onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
					&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="button" value="목록" 
					onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
					&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<%
			} catch (Exception e) {

			}
			%>
		</form>
	</div>
</body>
</html>