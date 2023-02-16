<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- 주소창 URL뒤에 ?type=guest 또는 member를 넣어보면 된다 -->
<!-- 참일 떄 출력 -->
<c:if test="${3>4}">
이 내용은 화면에 출력되지 않습니다.
</c:if>

<c:if test="${param.type eq 'guest'}">
HomePage방문을 환영하는 바입니다.<br>
회원가입을 하셔야 합니다<br>
</c:if>

<c:if test="${param.type eq 'member'}">
회원님의 방문을 환영하는 바입니다.<br>
즐거운 시간을 보내십오.<br>
더 나은 서비스로 보답하겠습니다.<br>
</c:if>

</body>
</html>