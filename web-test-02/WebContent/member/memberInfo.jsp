<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page = "membermenu.jsp"/>
<style type = "text/css">
.infoT {
	border-spacing : 3px;
	margin-left : 30%;
}

.infoT th{
	width : 300px;
	text-align : center;
	border : 1px solid black;
}
.infoT td{
	width : 300px;
	text-align : center;
	border : 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
<table class = infoT>

<tr>
<th colspan = "2" align = "center">
<h2>사원 정보</h2><br>
${message}
</th>
</tr>

<tr>
<th>아이디</th>
<td>${loginUser.id}</td>
</tr>
<tr>
<th>비밀번호</th>
<td>${loginUser.pw}</td>
</tr>
<tr>
<th>이름</th>
<td>${loginUser.name}</td>
</tr>
<tr>
<th>권한</th>
<td>
<c:choose>
<c:when test = "${loginUser.level == 'A' }">
관리자
</c:when>
<c:otherwise>
일반회원
</c:otherwise>
</c:choose>
</td>
</tr>
<tr>
<th>성별</th>
<td>
<c:choose>
<c:when test = "${loginUser.gender == '1' }">
남자
</c:when>
<c:otherwise>
여자
</c:otherwise>
</c:choose>
</td>
</tr>
<tr>
<th>전화번호</th>
<td>${loginUser.phone}</td>
</tr>
<tr>
<th colspan = "2" align = "center">
<input type = "button" value = "메인 페이지로 이동" onclick = "location.href = 'member/memberHome.jsp'">
</th>
</tr>

</table>
</body>
</html>