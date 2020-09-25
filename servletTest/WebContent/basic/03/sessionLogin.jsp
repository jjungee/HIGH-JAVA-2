<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Session 로그인 홈페이지</title>
	</head>
	
	<body>
		<form method="post" action="<%=request.getContextPath()%>/SessionLoginServlet.do">
			<h3>로그인</h3>
			ID : <input type="text" name="id"><br>
			PASS : <input type="password" name="pass"><br>
			<input type="submit" value="로그인">
		</form>
	</body>
</html>