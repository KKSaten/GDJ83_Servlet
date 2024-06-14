<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <style>
	#num {
		display: none;
	}


</style> -->

</head>
<body>

	<h1>날씨정보 페이지</h1>
	
	<h3>${requestScope.dto.city}</h3>
	<h3>${requestScope.dto.temperature}</h3>
	<h3>${requestScope.dto.status}</h3>
	<h3>${requestScope.dto.humidity}</h3>
	
	<form id="frm" action="/weather/delete" method="post">
		<input id="num" type="hidden" name="num" value="${requestScope.dto.num}">


	</form>
	
	
	<button id="btn">DELETE</button> <!-- 버튼을 form 태그 안에 안넣고 자바스크립트로 해결해보자 -->
	
	
	<script type="text/javascript">
		const frm = document.getElementById("frm");
		const btn = document.getElementById("btn");
		btn.addEventListener("click", function() {
			frm.submit();

			
			
			alert("삭제 완료");

		});

	</script>
	

</body>
</html>