package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//이 예제는 배포서술자(DD, Deployment Descriptor => web.xml파일)를 이용해서 실행하는 예제이다.

// 	http://localhost:80/serverTest/servletTest01.do
//	http	=> 프로토콜
//	lpcalhost 	=> 컴퓨터이름(도메인명) 또는 IP주소
//	80		=> PORT번호(80번은 생략 가능)
//	/servletTest	=> 컨텍스트 패스(보통 '웹프로젝트 이름'으로 자동 지정된다.)
//	/servletTest01.do	=> 서블릿 요청 URL패턴
//	

//http://localhost:포트번호/웹애플리케이션 명/문서명

//Servlet클래스는 HttpServlet을 상속해서 작성한다.
public class ServletTest01 extends HttpServlet{
	//이 곳에서는 대부분 doGet()메서드나 doPost()메서드를 재정의해서 작성한다.
	//service()메서드를 재정의해서 작성한는 방법도 있다.
	
	//doGet()메서드나 doPost()메서드에서는 service()메서드를 통해서 호출된다.
	//이 메서드에는 다음과 같은 객체를 매개변수로 갖는다.
	//	1) HttpServletRequest객체 => 서비스 요청에 관련된 정보 빛 메서드를 관리하는 객체
	//	2) HttpServletResponse객체 => 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
			resp.setCharacterEncoding("utf-8"); 	//응답 문서의 인코딩 방식을 지정
			resp.setContentType("text/html; charset=utf-8");
			
			//처리한 내용을 응답으로 보내기 위해서 PringWriter객체를 생성한다.
			PrintWriter out = resp.getWriter();
			
			//처리한 내용을 출력한다.	
			//	방법 1. append()메서드 이용하기
			out.append("<html>")
				.append("<head>")
				.append("<meta Charset='utf-8'>")
				.append("<title>첫번째 Servlet 연습</title>")
				.append("</head>")
				.append("<body>")
				.append("<h1 style='text-align:center;'>")
				.append("안녕하세요 첫번째Servlet 프로그램입니다.<br>")
				.append("Server 경로 : " + req.getContextPath())
				.append("</h1>")
			    .append("</body>")
			    .append("</html>");
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
			super.doPost(req, resp);
	}
}
