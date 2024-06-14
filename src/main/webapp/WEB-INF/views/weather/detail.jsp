<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>날씨정보 페이지</h1>
	
	<h3>${requestScope.dto.city}</h3>
	<h3>${requestScope.dto.temperature}</h3>
	<h3>${requestScope.dto.status}</h3>
	<h3>${requestScope.dto.humidity}</h3>

</body>
</html>