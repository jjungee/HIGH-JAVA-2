package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieReadServlet
 */
@WebServlet("/CookieReadServlet.do")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		//저장한 쿠키 읽어오기
		// 1. 전체 쿠키 정보를 request객체를 통해서 가져온다.
		//		=> 이 때 가져온 쿠키 정보들은 배열에 저장된다.
		// 	형식) Cookie[] 쿠키배열변수 = request.getCookie();
		Cookie[] cookieArr = request.getCookies();
		
		response.setContentType("text/html; charset=utf-8");
	      
	    PrintWriter out = response.getWriter();
	      
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head><meta charset='utf-8'>");
	    out.println("<title>Cookie 연습</title></head>");
	     
	      
	    out.println("<body>");
	    out.println("<h2>저장된 Cookie 데이터 확인하기</h2><br><br>");
	    
	    if(cookieArr==null || cookieArr.length  == 0){
	    	out.println("<h2>저장된 쿠키 정보가 하나도 없습니다.</h2>");
	    }
	    
	    // 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
	    for(Cookie cookie : cookieArr){
	    	String name = cookie.getName();
	    	
	    	//쿠키 값으로 저장된 데이터가 한글일 경우 디코딩해서 사용한다.
	    	// URLDecoder.decode()메서드 사용
	    	String value = URLDecoder.decode(cookie.getValue(), "utf-8");
	    	out.println("쿠키변수 : " + name + "<br>");
	    	out.println("쿠키값 : " + value + "<br><hr>");
	    }
		    out.println("<a href='" + request.getContextPath()
		            + "/basic/02/cookieTest.jsp'>시작문서로 이동</a>");
		    out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
