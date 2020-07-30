<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page = "membermenu.jsp"/>
<title>Insert title here</title>
<script type = "text/javascript" src = "http://localhost:8181/web-test-02/script/checkinfo.js"></script>
<style type = "text/css">
.mypageT {
	border-spacing : 3px;
	margin-left : 30%;
}

.mypageT th {
	border : 1px solid black;
	text-align : center;
	width : 300px;
}

.mypageT td {
	border : 1px solid black;
	width : 300px;
}
</style>
</head>
<body>
<form method = "post" name = "frm" action = "http://localhost:8181/web-test-02/change.do">
<table class = "mypageT">
<tr><th colspan = "2" align = "center">마이페이지</th></tr>
<tr><th>아이디</th>
<td align = "center">
<input type = "text" name = "id" size = "15" value = "${loginUser.id}" readonly>
</td></tr>
<tr><th>비밀번호</th>
<td align = "center">
<input type = "password" name = "pw" value = "${loginUser.pw}" size = "15">
</td></tr>
<tr><th>이름</th>
<td align = "center">
<input type = "text" name = "name" size = "15" value = "${loginUser.name}">
</td></tr>
<tr><th>권한</th>
<td align = "center">
<select size = "1" name = "level">
<c:choose>
<c:when test = "${loginUser.level == 'A'}">
<option value = "A" selected> 관리자 </option>
<option value = "B"> 일반회원 </option>
</c:when>
<c:otherwise>
<option value = "A"> 관리자 </option>
<option value = "B" selected> 일반회원 </option>
</c:otherwise>
</c:choose>
</select>
</td></tr>
<tr><th>성별</th>
<td align = "center">
<select size = "1" name = "gender">
<c:choose>
<c:when test = "${loginUser.gender == 1}">
<option value = "1" selected> 남자 </option>
<option value = "2"> 여자 </option>
</c:when>
<c:otherwise>
<option value = "1"> 남자 </option>
<option value = "2" selected> 여자 </option>
</c:otherwise>
</c:choose>
</select>
</td></tr>
<tr><th>전화번호</th>
<td align = "center">
<input type = "text" name = "phone" size = "30" value = "${loginUser.phone}">
</td></tr>

<tr>
<th colspan = "2" align = "center">
<input type = "submit" value = "등록" onclick = "return check()">
<input type = "reset" value = "취소">
<input type = "button" value = "메인 페이지로 이동" onclick = "location.href = 'memberHome.jsp'">
</th>
</tr>

</table>
</form>

</body>
</html>