<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h2>sendRedirect와 forward 연습</h2>
		<hr>
		<form action="/servletTest/ResponseTest01.do" method="post">
			sendredirect : <input type="text" name="username">
			<input type="submit" value="확인">
		</form>
		<hr>
		<form action="/servletTest/ResponseTest02.do" method="post">
			forward : <input type="text" name="username">
			<input type="submit" value="확인">
		</form>
	</body>
</html>