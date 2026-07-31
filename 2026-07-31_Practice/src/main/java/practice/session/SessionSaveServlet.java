package practice.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionSaveServlet
 */
@WebServlet("/sessionSave")
public class SessionSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO: 입력된 닉네임(nickname)과 연락처(tel)를 
		//				세션 영역(HttpSession)에 저장 하세요.
		
		// * 요청 파라미터 추출
		String nickname = request.getParameter("nickname");
		String tel = request.getParameter("tel");
		
		// * 세션 영역에 저장 ==> 요청 객체
		HttpSession session = request.getSession();
		
		session.setAttribute("nickname", nickname);
		session.setAttribute("tel", tel);
		
	    // [응답 출력 형식] <h2>세션 정보 저장 완료</h2>
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h2>세션 정보 저장 완료</h2>");
	}

}



