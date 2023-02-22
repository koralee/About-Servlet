<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%--
 JNDI가 설정되어 있지 않으면
<sql:setDataSource  
url="jdbc:oracle:thin:@127.0.0.1:1521:orcl" 
driver="oracle.jdbc.driver.OracleDriver" 
user="scott" password="tiger" var="ds" 
scope="application" />

--%>
 <!-- JNDI 가 설정되어 있으면 -->
<sql:setDataSource  dataSource="jdbc/myoracle" 
var="ds" scope="application" />



<sql:query var="rs" dataSource="${ds}"  >
     SELECT * from tempmember
</sql:query>
<!-- dataSource="jdbc/myoracle" -->
<table border="1">
   <tr>
   <%-- 필드명 출력 --%>
         <c:forEach var="columnName" items="${rs.columnNames }">
            <th><c:out value="${columnName}" /></th>
         </c:forEach>   
         
     <%-- 레코드 수만큼 반복 실행함 --%>     
         
     <c:forEach var="row" items="${rs.rowsByIndex}">
     <tr>
           <%-- 레코드의 필드수 만큼  반복 실행함 --%>
           <c:forEach var="column" items="${row}" varStatus="i">
              <td>
                  <c:if test="${ ! empty column  }"><%-- 필드값이 존재한다면 --%>
                      <c:out value="${column}" />
                  </c:if>
                  <c:if test="${ column == null }"><%-- 필드값이 존재하지 않는다면 --%>
                          &nbsp;                  
                  </c:if>
             </td>
          </c:forEach>  
     </tr>    
     </c:forEach>
         
   </tr>
</table>
</body>
</html>