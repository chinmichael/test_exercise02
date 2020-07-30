<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
<head>
<jsp:include page = "membermenu.jsp"/>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style = "text-align : center;">회원 전용 페이지</h1>
<c:url value = "/image/DAOL.jpg" var = "data"></c:url>
<img src = "${data}" width = '350' height = '200' style = "margin-left : 39%;">
</body>
</html>