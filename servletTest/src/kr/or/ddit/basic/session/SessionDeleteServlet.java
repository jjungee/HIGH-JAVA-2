package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDeleteServlet
 */
@WebServlet("/SessionDeleteServlet.do")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 삭제하기
		
		// 1. Session객체 구하기
		HttpSession session = request.getSession();
		
		// 2. 세션값만 삭제하기 => removeAttribute()메서드 이용
		//	형식) session객체.removeAttribute("세션key값");
		
		// 3. 세션 자체를 삭제하기 => invalidata()메서드 사용
		// 	형식) session객체.invalidate();
		session.removeAttribute("testSession");
		
		session.invalidate();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head><meta charset='utf-8'>");
	    out.println("<title>Session 연습 </title></head>");
	     
	      
	    out.println("<body>");
	    out.println("<h2>Session 데이터가 삭제되었습니다.</h2><br><br>");
	    out.println("<a href='" + request.getContextPath()
	            + "/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
	    out.println("</body></html>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
