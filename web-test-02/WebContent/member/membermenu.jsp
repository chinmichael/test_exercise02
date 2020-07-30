<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dbpackage.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script type = "text/javascript">

</script>

<style type = "text/css">

header {
	width : 100%;
	top : 0;
	left : 0;
}

.menuT {
	border-spacing: 5px;
	width : 100%;
}

.menuT th {
	border: 1px solid #444444;
	width : 20%;
}

</style>

<header>
<table class = "menuT">
	<tr>
	<th>${loginUser.name}님 반갑습니다</th>
	<th>레벨 : ${loginUser.level}</th>
	<th onclick = "location.href = 'http://localhost:8181/web-test-02/logout.do'">로그아웃</th>
	<c:choose>
	<c:when test = "${loginUser.level == 'B'}">
		<th>사원등록<br>(관리자로 로그인해야 사용가능)</th>
	</c:when>
	<c:otherwise>
		<th onclick = "location.href = 'registmember.jsp'">사원등록</th>
	</c:otherwise>
	</c:choose>
	<th onclick = "location.href = 'infochange.jsp'">마이페이지</th>
	</tr>
</table>
</header>