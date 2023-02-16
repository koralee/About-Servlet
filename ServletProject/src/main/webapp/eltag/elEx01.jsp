<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.actiontag.Customer, java.util.HashMap" %>
<%
	Customer customer = new Customer();
	customer.setName("손오공");
	customer.setEmail("son@naver.com");
	customer.setPhone("010-1234-5678");
	request.setAttribute("customer", customer); //key값 , value값
	
	HashMap<String, String> map = new HashMap<>();
	map.put("name", "소나타");
	map.put("maker", "현대[급발진]자동차");
	request.setAttribute("car",map); //key값 , value값
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
	<li>구매자 이름 : ${customer.name }</li>
	<li>구매자 메일 : ${customer.email }</li>
	<li>구매자 전화 : ${customer.phone }</li>
</ul>

<ul>
	<li>자동차 : ${car.name}</li>
	<li>제조사 : ${car.maker}</li>
</ul>
</body>
</html>