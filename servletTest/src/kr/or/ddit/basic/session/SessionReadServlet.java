package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionReadServlet
 */
@WebServlet("/SessionReadServlet.do")
public class SessionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Session 정보 읽어오기
		
		// 1. 세션 객체 구하기
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head><meta charset='utf-8'>");
	    out.println("<title>Session 연습 </title></head>");
	      
	    out.println("<body>");
	    out.println("<h2>저장된 Session 데이터 확인하기</h2><br><br>");
	    
	    // 2. getAttribute()메서드로 Session값을 읽어온다.
	    //	형식) Session객체.getAttribute("세션key값");
	    String sessionData = (String) session.getAttribute("testSession");
	    if(sessionData==null){
	    	out.println("<h3>testSession의 세션값은 없습니다.</h3>");
	    }else{
	    	out.println("<h2>testSession의 세션값 : " + sessionData + "</h2>");
	    }
	    
	    // 전체 세션 정보 구하기 => getAttributeNames()메서드 이용
	    //  형식) session객체.getAttributeNames();
	    //		=> 세션에 저장한 모든 '세션key값'들을 구해서 Enumeration객체로 반환한다.
	    out.println("<hr>");
	    out.println("<h3>전체 세션 데이터 확인하기</h3>");
	    out.println("<ol>");
	    
	    Enumeration<String> sessionNames = session.getAttributeNames();
	    int cnt = 0;
	    while (sessionNames.hasMoreElements()) {
	    	cnt++;
	    	String sessionKey = sessionNames.nextElement();
	    	out.println("<li>" + sessionKey + " : " + session.getAttribute(sessionKey));
		}
	    
	    if (cnt == 0) {
	    	out.println("<li>세션 데이터가 하나도 없습니다</li>");
		}
	    out.println("</ol>");
	    out.println("<hr>");
	    // 세션ID => 세션을 구분하기 위한 고유한 값
	    out.println("세션 ID : " + session.getId() + "<br>");
	    // 생성시간 => 1970년 1월 1일부터 경과한 시간을 반환(밀리세컨드 단위)
	    out.println("세션 생성시간 : " + session.getCreationTime() + "<br>");
	    // 최근 접근 시간 => 1970년 1월1일부터 경과한 시간을 반환(밀리세컨드 단위)
	    out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
	    // 세션 유효 시간 => 초단위
	    //		세션의 최근 접근 시간부터 '세션 유효 시간'이 경과되면 세션이 자동으로 삭제된다.
	    out.println("세션 최근 접근 시간 : " + session.getMaxInactiveInterval() + "<br>");
	    
	    //세션의 유효시간을 설정하려면 'session객체.setMaxInactivenInterval(초단위 시간)'을 사용해서 설정한다.
	    
	    
	    out.println("<hr>");
	    out.println("<a href='" + request.getContextPath()
	            + "/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
	    out.println("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
