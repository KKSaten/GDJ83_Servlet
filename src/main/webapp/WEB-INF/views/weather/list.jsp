<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	
	<h1>날씨전체정보 페이지</h1>
	
	<table class="tbl">
		<thead>
			<tr>
				<th>도시</th>
				<th>기온</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="w">
				<tr>
					<td>${pageScope.w.city}</td>
					<td>${pageScope.w.temperature}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	
	</table>
	
</body>
</html>