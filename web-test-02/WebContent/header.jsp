<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<th></th>
	<th></th>
	<th onclick = "location.href = 'login.jsp'">로그인</th>
	<th>사원등록<br>(관리자로 로그인해야 사용가능)</th>
	<th>마이페이지<br>(로그인해야 사용가능)</th>
	</tr>
</table>
</header>