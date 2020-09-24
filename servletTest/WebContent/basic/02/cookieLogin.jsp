<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%
			//쿠키값 가져오기
			String cookieUserId = "";	// 쿠키값을 저장할 변수
			String check = "";			// 체크박스의 체크 상태
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0){
				for(int i = 0 ; i < cookies.length ; i++){
					if(cookies[i].getName().equals("idCookie")){
						//원하는 쿠키 값을 찾아서 저장하기
						cookieUserId = cookies[i].getValue();
						check = "checked";
					}
				}
			}
		%>
	
		<form action="/servletTest/cookieLoginCheckServlet.do" method="post">
			아이디 <input type="text" name="id" value="<%=cookieUserId%>"><input type="checkbox" name="chkid" <%=check %> >id기억하기<br>
			비밀번호 <input type="password" name="pass"><br>
			<input type="submit" value="로그인">
		</form>	
	</body>
</html>