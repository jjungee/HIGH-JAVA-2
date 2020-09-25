<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
<!-- 		로그인 성공 시 ~~님 반갑 실패하면 alert 로그인 실패 , 로그아웃-->
<!-- 이전페이지로 이동 -->

		<%
		String id =(String)session.getAttribute("id");
		
		if(id == null){
		%>
			<script type="text/javascript">
				alert("로그인 실패!!"); 
				history.go(-1);
			</script>
		<%
		} else{
		%>	
		<%=id %>님 안녕
		<a href="<%=request.getContextPath()%>/SessionLogoutServlet.do">로그아웃</a>
		<%
		}
		%>
	</body>
</html>