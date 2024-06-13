<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>학생정보 페이지</h1>

	<!-- EL(Expression Language 요새 문법. 표현언어. 데이터 출력 전용-->
	<%-- ${스코프영역명.속성명) --%> <!-- 왼쪽은 jsp주석법임 -->
	<!-- getter의 이름 : get을 빼고 첫글자를 소문자로 바꾼 것 -->
	<!-- setter의 이름 : set을 빼고 첫글자를 소문자로 바꾼 것 -->
	<!-- 멤버변수명과 같아 보이지만 멤버변수명이라 생각하면 안됨 -->
	<h3> ${requestScope.std.num}</h3>
	<h3> ${requestScope.std.name}</h3>
	<h3> ${requestScope.std.kor}</h3>
	<h3> ${requestScope.std.eng}</h3>
	<h3> ${requestScope.std.math}</h3>
	<h3> ${requestScope.std.total}</h3>
	<h3> ${requestScope.std.avg}</h3>
	
</body>
</html>