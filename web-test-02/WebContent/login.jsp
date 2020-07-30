<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page = "header.jsp" />
<style type = "text/css">
.loginT {
	border-spacing : 2px;
	margin-left : 40%;
}

.loginT th {
	border : 1px solid black;
	width : 150px;
}

.loginT td {
	width : 150px;
	border : 1px solid black;
}
	
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "login.do" name = "loginfrm">
<table class = "loginT">
<tr><th colspan = "2" align = "center">로그인</th></tr>
<tr>
<th>아이디</th><td align = "center"><input type = "text" name = "userid" size = "15"></td>
</tr>
<tr>
<th>비밀번호</th><td align = "center"><input type = "password" name = "userpw" size = "15"></td>
</tr>
<tr>
<th>레벨</th><td align = "center">
<select size = "1" name = "level" id = "level">
<option value = "일반">일반회원</option>
<option value = "관리">관리자</option>
</select>
</td>
</tr>
<tr>
<th colspan = "2" align = "center">
<input type = "submit" value = "로그인"> &nbsp;
<input type = "reset" value = "취소">
</th>
</tr>
</table>
</form>
<c:choose>
<c:when test = "${result == 1}">
<script>location.href = "member/memberHome.jsp";</script>
</c:when>
<c:when test = "${result == 0}">
<script>alert("비밀번호, 등급을 확인해주세요");</script>
</c:when>
<c:when test = "${result == -1}">
<script>alert("존재하지 않는 계정입니다");</script>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>