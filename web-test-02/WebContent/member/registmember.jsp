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
<form method = "post" name = "frm" action = "http://localhost:8181/web-test-02/regist.do">
<table class = "mypageT">
<tr><th colspan = "2" align = "center">사원등록</th></tr>
<tr><th>아이디</th>
<td align = "center">
<input type = "text" name = "id" size = "15">
</td></tr>
<tr><th>비밀번호</th>
<td align = "center">
<input type = "password" name = "pw">
</td></tr>
<tr><th>이름</th>
<td align = "center">
<input type = "text" name = "name" size = "15">
</td></tr>
<tr><th>권한</th>
<td align = "center">
<select size = "1" name = "level">
<option value = "A"> 관리자 </option>
<option value = "B" selected> 일반회원 </option>
</select>
</td></tr>
<tr><th>성별</th>
<td align = "center">
<select size = "1" name = "gender">
<option value = "1" selected> 남자 </option>
<option value = "2"> 여자 </option>
</select>
</td></tr>
<tr><th>전화번호</th>
<td align = "center">
<input type = "text" name = "phone" size = "30">
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
<c:if test = "${message == 'fail' }">
<script>alert("이미 존재하는 아이디입니다");</script>
</c:if>
</body>
</html>